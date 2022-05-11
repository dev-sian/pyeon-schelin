package com.devsian.comment.entity;

import com.devsian.user.entity.User;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    Integer id;
    User commentWriter;
    String content;
    ZonedDateTime createdAt;
}
