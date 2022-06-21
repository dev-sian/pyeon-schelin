package com.devsian.post.dto;

import com.devsian.post.CSName;
import com.devsian.post.PostType;
import com.devsian.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "postType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ReviewPostCreateDTO.class, name = "REVIEW_POST"),
        @JsonSubTypes.Type(value = GeneralPostCreateDTO.class, name = "GENERAL_POST")
})
public class PostCreateDTO {
    private String title;
    private String content;
    private Integer boardId;
    private PostType postType;
    private Integer writerId;

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
