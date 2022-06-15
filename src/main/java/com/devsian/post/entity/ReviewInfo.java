package com.devsian.post.entity;

import com.devsian.post.CSName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewInfo {
    Integer id;
    Integer postId;
    String productName;
    CSName csName;
    Double rating;
}
