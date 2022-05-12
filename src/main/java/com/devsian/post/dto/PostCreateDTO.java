package com.devsian.post.dto;

import com.devsian.post.PostType;
import com.devsian.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostCreateDTO {
    String title;
    String content;
    Integer boardId;
    PostType postType;
    Integer writerId;

    public Post toPost(){
        var post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setBoardId(boardId);
        post.setPostType(postType);
        post.setWriterId(writerId);

        return post;
    }
}
