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
    protected Integer id;
    protected String title;
    protected String content;
    protected Integer boardId;
    protected PostType postType;
    protected Integer writerId;
    protected Integer views;
    protected ZonedDateTime createdAt;
}
