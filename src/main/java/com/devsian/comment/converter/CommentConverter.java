package com.devsian.comment.converter;


import com.devsian.comment.dto.CommentCreateDTO;
import com.devsian.comment.dto.CommentReadDTO;
import com.devsian.comment.dto.CommentUpdateDTO;
import com.devsian.comment.entity.Comment;
import com.devsian.user.entity.User;
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

    public static Comment of(CommentCreateDTO commentCreateDTO) {
        return Comment.builder()
                .postId(commentCreateDTO.getPostId())
                .commentWriter(new User(commentCreateDTO.getUserId()))
                .content(commentCreateDTO.getContent())
                .build();
    }

    public static Comment of(Integer writerId, CommentUpdateDTO commentUpdateDTO) {
        return Comment.builder()
                .commentWriter(new User(writerId))
                .content(commentUpdateDTO.getContent())
                .build();
    }
}
