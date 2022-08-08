package com.devsian.post.dto;

import com.devsian.post.entity.GeneralPost;
import com.devsian.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GeneralPostCreateDTO extends PostCreateDTO {
    @Override
    public GeneralPost toPost() {
        var post = new GeneralPost();
        super.setPost(post);
        return post;
    }
}
