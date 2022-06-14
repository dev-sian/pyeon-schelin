package com.devsian.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Builder
public class CommentReadDTO {
    private Integer id;
    private String content;
    private String nickname;
    private ZonedDateTime createdAt;
}
