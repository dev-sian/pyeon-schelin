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
    private Integer id;
    private String title;
    private String content;
    private Integer writerId;
    private Integer views;
    private ZonedDateTime createdAt;
}
