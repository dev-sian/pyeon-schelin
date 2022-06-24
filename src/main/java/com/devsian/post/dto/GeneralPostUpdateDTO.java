package com.devsian.post.dto;

import com.devsian.post.entity.GeneralPost;

public class GeneralPostUpdateDTO extends PostUpdateDTO{
    @Override
    public GeneralPost toPost(Integer postId) {
        var post = new GeneralPost();
        super.setPost(post, postId);
        return post;
    }
}
