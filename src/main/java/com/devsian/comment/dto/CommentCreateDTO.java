package com.devsian.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CommentCreateDTO {
    private Integer userId;
    private Integer postId;
    private String content;
}
