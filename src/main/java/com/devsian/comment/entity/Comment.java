package com.devsian.comment.entity;

import com.devsian.user.entity.User;

import java.time.ZonedDateTime;

public class Comment {
    Integer id;
    User commentWriter;
    String content;
    ZonedDateTime createdAt;
}
