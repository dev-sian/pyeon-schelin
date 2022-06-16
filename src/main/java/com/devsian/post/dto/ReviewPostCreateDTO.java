package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.entity.ReviewInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPostCreateDTO extends PostCreateDTO{
    private Integer postId;
    private String productName;
    private CSName csName;

    public ReviewInfo toReviewInfo(){
        return ReviewInfo.builder()
                .postId(postId)
                .productName(productName)
                .csName(csName)
                .build();
    }
}
