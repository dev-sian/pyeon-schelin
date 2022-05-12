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
    Integer userId;
    Integer postId;
    String content;
}
