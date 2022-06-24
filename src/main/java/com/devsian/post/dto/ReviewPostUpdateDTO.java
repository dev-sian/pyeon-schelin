package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.entity.ReviewInfo;
import com.devsian.post.entity.ReviewPost;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPostUpdateDTO extends PostUpdateDTO{
    private String productName;
    private CSName csName;

    @Override
    public ReviewPost toPost(Integer postId) {
        var post = new ReviewPost();
        super.setPost(post, postId);
        post.setProductName(productName);
        post.setCsName(csName);
        return post;
    }
}
