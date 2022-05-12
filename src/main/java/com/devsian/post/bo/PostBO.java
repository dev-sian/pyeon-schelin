package com.devsian.post.bo;

import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;

import java.util.List;

public abstract class PostBO {
    public abstract List<PostReadDTO> getAllPost(List<Post> posts);
}
