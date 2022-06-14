package com.devsian.comment.entity;

import com.devsian.user.entity.User;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private Integer id;
    private Integer postId;
    private User commentWriter;
    private String content;
    private ZonedDateTime createdAt;
}
