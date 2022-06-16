package com.devsian.post.entity;

import com.devsian.post.CSName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewInfo {
    private Integer id;
    private Integer postId;
    private String productName;
    private CSName csName;
    private Double rating;
}
