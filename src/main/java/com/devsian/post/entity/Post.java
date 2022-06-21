package com.devsian.post.entity;

import com.devsian.post.PostType;
import com.devsian.user.dto.UserReadDTO;
import com.devsian.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.ArrayList;

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
