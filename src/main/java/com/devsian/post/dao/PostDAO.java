package com.devsian.post.dao;

import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostDAO {
    @Select("SELECT * FROM post WHERE boardId=#{boardId}")
    List<Post> selectAllPosts(Integer boardId);

    @Select("SELECT * FROM reviewInfo")
    List<ReviewInfo> selectAllReviewInfo();
}
