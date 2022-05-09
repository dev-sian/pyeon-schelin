package com.devsian.post.dao;

import com.devsian.post.entity.ReviewPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewPostDAO {
    List<ReviewPost> selectAll();
}
