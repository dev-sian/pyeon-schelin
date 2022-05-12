package com.devsian.comment.dao;

import com.devsian.comment.dto.CommentUpdateDTO;
import com.devsian.comment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    // C
    void insert(Comment comment);
    // R
    List<Comment> selectAll(int postId, int offset);
    // U
    void update(Comment comment);
}
