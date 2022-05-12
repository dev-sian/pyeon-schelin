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
    Integer id;
    Integer postId;
    User commentWriter;
    String content;
    ZonedDateTime createdAt;
}
