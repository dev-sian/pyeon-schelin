package com.devsian.post.dto;

import com.devsian.post.entity.ReviewPost;
import com.devsian.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewPostTotalReadDTO {
    Integer id;
    String productName;
    Integer views;
    Double rating;
    String nickname;

    public ReviewPostTotalReadDTO(ReviewPost reviewPost) {
        id = reviewPost.getId();
        productName = reviewPost.getProductName();
        views = reviewPost.getViews();
        rating = reviewPost.getRating();
        nickname = reviewPost.getWriter().getName();
    }
}
