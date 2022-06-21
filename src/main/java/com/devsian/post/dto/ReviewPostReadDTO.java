package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewPostReadDTO extends PostReadDTO{
    private String productName;
    private CSName csName;
    private Double rating;
    public ReviewPostReadDTO(Post post, ReviewInfo reviewInfo){
        setTitle(post.getTitle());
        setId(post.getId());
        setContent(post.getContent());
        setWriterId(post.getWriterId());
        setViews(post.getViews());
        setCreatedAt(post.getCreatedAt());

        this.productName = reviewInfo.getProductName();
        this.csName = reviewInfo.getCsName();
        this.rating = reviewInfo.getRating();
    }
}
