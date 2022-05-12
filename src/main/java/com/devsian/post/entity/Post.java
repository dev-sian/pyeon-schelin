package com.devsian.post.entity;

import com.devsian.post.PostType;
import com.devsian.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public abstract class Post {
    Integer id;
    String title;
    String content;
    Integer boardId;
    PostType postType;
    ArrayList<String> images;
    User writer;
    Integer views;
    ZonedDateTime createdAt;
}
