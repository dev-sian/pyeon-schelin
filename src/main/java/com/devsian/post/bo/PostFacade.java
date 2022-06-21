package com.devsian.post.bo;

import com.devsian.post.PostType;
import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostFacade {
    private final PostDAO postDAO;

    public List<PostReadDTO> getAllPost(Integer boardId){
        var posts = postDAO.selectAllPosts(boardId);

        PostType postType = posts.stream()
                .findAny()
                .map(Post::getPostType)
                .orElse(null);

        PostBO postBO = getPostBO(postType);

        return postBO.getAllPost(posts);
    }

    public PostReadDTO getPost(Integer postId){
        var post = postDAO.selectPost(postId);

        PostType postType = post.getPostType();

        PostBO postBO = getPostBO(postType);

        return postBO.getPost(post);
    }

    public PostReadDTO createPost(PostCreateDTO postCreateDTO){
        PostType postType = postCreateDTO.getPostType();

        PostBO postBO = getPostBO(postType);

        return postBO.createPost(postCreateDTO);
    }

    PostBO getPostBO(PostType postType){
        PostBO postBO = null;

        switch(postType){
            case GENERAL_POST:
                postBO = new GeneralPostBO(postDAO);
                break;
            case REVIEW_POST:
                postBO = new ReviewPostBO(postDAO);
                break;
            default:
                log.error("없는 post type");
                break;
        }

        return postBO;
    }
}
