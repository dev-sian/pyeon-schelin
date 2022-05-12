package com.devsian.post.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor
public class PostReadDTO {
    String title;
    String content;
    Integer writerId;
    Integer views;
    ZonedDateTime createdAt;
}
