package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.entity.GeneralPost;
import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import com.devsian.post.entity.ReviewPost;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPostCreateDTO extends PostCreateDTO{
    private Integer postId;
    private String productName;
    private CSName csName;

    @Override
    public ReviewPost toPost() {
        var post = new ReviewPost();
        super.setPost(post);
        post.setProductName(productName);
        post.setCsName(csName);
        return post;
    }
}
