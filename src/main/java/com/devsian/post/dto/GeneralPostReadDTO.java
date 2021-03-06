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
        setId(post.getId());
        setTitle(post.getTitle());
        setContent(post.getContent());
        setWriterId(post.getWriterId());
        setViews(post.getViews());
        setCreatedAt(post.getCreatedAt());
    }
}
