package com.devsian.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostReadDTO {
    String title;
    String content;
    Integer writerId;
    Integer views;
    ZonedDateTime createdAt;
}
