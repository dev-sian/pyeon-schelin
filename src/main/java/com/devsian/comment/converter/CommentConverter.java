package com.devsian.comment.converter;


import com.devsian.comment.dto.CommentReadDTO;
import com.devsian.comment.entity.Comment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * CreateDTO -> entity (DB)
 * ReadDTO <- entity (DB)
 */
public class CommentConverter {
    public static CommentReadDTO of(Comment comment) {
        return CommentReadDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .nickname(comment.getCommentWriter().getName())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
