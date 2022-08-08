package com.devsian.post.entity;

import com.devsian.post.CSName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPost extends Post{
    private String productName;
    private CSName csName;
    private Double rating;

    public ReviewInfo toReviewInfo(){
        return ReviewInfo.builder()
                .postId(getId())
                .productName(productName)
                .csName(csName)
                .build();
    }
}
