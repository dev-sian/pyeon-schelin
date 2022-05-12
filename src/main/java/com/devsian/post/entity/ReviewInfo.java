package com.devsian.post.entity;

import com.devsian.post.CSName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewInfo {
    Integer id;
    Integer postId;
    String productName;
    CSName csName;
    Double rating;
}
