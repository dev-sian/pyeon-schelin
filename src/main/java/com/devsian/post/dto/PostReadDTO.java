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
    protected String title;
    protected String content;
    protected Integer writerId;
    protected Integer views;
    protected ZonedDateTime createdAt;
}
