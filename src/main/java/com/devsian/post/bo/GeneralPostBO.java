package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.GeneralPostReadDTO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralPostBO extends PostBO{

    @Autowired
    public GeneralPostBO(PostDAO postDAO) {
        super(postDAO);
    }

    @Override
    public List<PostReadDTO> getAllPost(List<Post> posts) {
        return posts.stream()
                .map(GeneralPostReadDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostReadDTO getPost(Post post) {
        return new GeneralPostReadDTO(post);
    }

    @Override
    public void createPost(PostCreateDTO postCreateDTO) {
        super.createPost(postCreateDTO);
    }

    @Override
    public void updatePost(Integer postId, PostUpdateDTO postUpdateDTO) {
        super.updatePost(postId, postUpdateDTO);
    }

    @Override
    public void deletePost(Integer postId) {
        super.deletePost(postId);
    }
}
