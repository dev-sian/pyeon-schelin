package com.devsian.comment.dao;

import com.devsian.comment.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    List<Comment> selectAll(int postId, int offset);
}
