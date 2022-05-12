package com.devsian.post.bo;

import com.devsian.post.PostType;
import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostApiBO {
    private final PostDAO postDAO;

    public List<PostReadDTO> getAllPost(Integer boardId){
        var posts = postDAO.selectAllPosts(boardId);

        PostType postType = posts.stream()
                .findAny()
                .map(Post::getPostType)
                .orElse(null);

        PostBO postBO = null;

        switch(postType){
            case GENERAL_POST:
                postBO = new GeneralPostBO(postDAO);
                break;
            case REVIEW_POST:
                postBO = new ReveiwPostBO(postDAO);
                break;
            default:
                log.error("없는 post type");
                break;
        }

        return postBO.getAllPost(posts);
    }
}
