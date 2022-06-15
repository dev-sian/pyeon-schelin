package com.devsian.post.dto;

import com.devsian.post.bo.GeneralPostBO;
import com.devsian.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@ToString
public class GeneralPostReadDTO extends PostReadDTO{
    public GeneralPostReadDTO(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerId = post.getWriterId();
        this.views = post.getViews();
        this.createdAt = post.getCreatedAt();
    }
}
