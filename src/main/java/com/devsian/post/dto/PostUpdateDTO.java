package com.devsian.post.dto;

import com.devsian.post.PostType;
import com.devsian.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "postType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ReviewPostUpdateDTO.class, name = "REVIEW_POST"),
        @JsonSubTypes.Type(value = GeneralPostUpdateDTO.class, name = "GENERAL_POST")
})
public abstract class PostUpdateDTO {
    private String title;
    private String content;
    private Integer boardId;
    private PostType postType;

    public Post setPost(Post post, Integer postId){
        post.setId(postId);
        post.setTitle(title);
        post.setContent(content);
        post.setBoardId(boardId);
        post.setPostType(postType);

        return post;
    }

    public abstract Post toPost(Integer postId);
}
