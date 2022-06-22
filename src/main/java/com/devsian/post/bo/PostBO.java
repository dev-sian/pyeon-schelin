package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class PostBO {
    protected final PostDAO postDAO;

    public abstract List<PostReadDTO> getAllPost(List<Post> posts);

    public abstract PostReadDTO getPost(Post post);
    public void createPost(PostCreateDTO postCreateDTO){
        var post = postCreateDTO.toPost();

        postDAO.insertPost(post);
    }

    public void deletePost(Integer postId){
        /*
        * TODO: writer 검증
        *  */
        postDAO.deletePost(postId);
    }
}
