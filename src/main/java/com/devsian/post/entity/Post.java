package com.devsian.post.entity;

import com.devsian.post.PostType;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Post {
    private Integer id;
    private String title;
    private String content;
    private Integer boardId;
    private PostType postType;
    private Integer writerId;
    private Integer views;
    private ZonedDateTime createdAt;
}
