package com.devsian.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewPost extends Post{
    String productName;
    String csName;
    Double rating;
}
