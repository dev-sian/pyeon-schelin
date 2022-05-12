package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.GeneralPostReadDTO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GeneralPostBO extends PostBO{
    private final PostDAO postDAO;

    @Override
    public List<PostReadDTO> getAllPost(List<Post> posts) {
        return posts.stream()
                .map(GeneralPostReadDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostReadDTO createPost(PostCreateDTO postCreateDTO) {
        var post = postCreateDTO.toPost();

        postDAO.insertPost(post);

        return new GeneralPostReadDTO(post);
    }
}
