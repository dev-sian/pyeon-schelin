package com.devsian.post.dto;

import com.devsian.post.PostType;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class PostCreateDTO {
    String title;
    String content;
    Integer boardId;
    PostType postType;
    ArrayList<String> images;
    Integer writerId;
    Integer views;
    ZonedDateTime createdAt;
}
