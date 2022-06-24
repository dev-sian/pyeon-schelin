package com.devsian.post.dao;

import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostDAO {
    @Select("SELECT * FROM post WHERE boardId=#{boardId} LIMIT #{offset}, #{limit}")
    List<Post> selectPostList(Integer boardId, Integer limit, Integer offset);

    @Select("SELECT * FROM post WHERE id=#{postId}")
    Post selectPost(Integer postId);

    List<ReviewInfo> selectReviewInfoList(List<Integer> idList);

    @Select("SELECT * FROM reviewInfo WHERE postId=#{postId}")
    ReviewInfo selectReviewInfo(Integer postId);

    @Select("SELECT COUNT(*) FROM post WHERE boardId=#{boardId}")
    Integer selectCount(Integer boardId);

    @Insert("INSERT INTO post(title, content, boardId, postType, writerId) VALUES(#{title}, #{content}, #{boardId}, #{postType}, #{writerId})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    Integer insertPost(Post post);

    @Insert("INSERT INTO reviewInfo(postId, productName, csName) VALUES(#{postId}, #{productName}, #{csName})")
    Integer insertReviewInfo(ReviewInfo reviewInfo);

    @Delete("DELETE FROM post WHERE id=#{postId}")
    void deletePost(Integer postId);

    @Delete("DELETE FROM reviewInfo WHERE postId=#{postId}")
    void deleteReviewInfo(Integer postId);

    void updatePost(Post post);

    void updateReviewInfo(ReviewInfo reviewInfo);
}
