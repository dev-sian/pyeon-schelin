package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.entity.ReviewInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPostUpdateDTO extends PostUpdateDTO{
    private String productName;
    private CSName csName;

    public ReviewInfo toReviewInfo(Integer postId){
        return ReviewInfo.builder()
                .postId(postId)
                .productName(productName)
                .csName(csName)
                .build();
    }
}
