package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostBO {
    public List<PostReadDTO> getAllPost(List<Post> posts){
        return null;
    }

    public PostReadDTO getPost(Post post){return null;}
    public PostReadDTO createPost(PostCreateDTO postCreateDTO){
        return null;
    }
}