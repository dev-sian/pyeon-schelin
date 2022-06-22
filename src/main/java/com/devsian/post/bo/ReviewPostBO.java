package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.*;
import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReviewPostBO extends PostBO {

    @Autowired
    public ReviewPostBO(PostDAO postDAO) {
        super(postDAO);
    }

    @Override
    public List<PostReadDTO> getAllPost(List<Post> posts) {

        var reviewInfos = postDAO.selectAllReviewInfo();

        var postIdToReviewInfo = reviewInfos.stream()
                .collect(Collectors.toMap(ReviewInfo::getPostId, Function.identity()));

        return posts.stream()
                .map(post ->{
                    return new ReviewPostReadDTO(post, postIdToReviewInfo.get(post.getId()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public PostReadDTO getPost(Post post) {
        var reviewInfo = postDAO.selectReviewInfo(post.getId());

        return new ReviewPostReadDTO(post, reviewInfo);
    }

    @Override
    public void createPost(PostCreateDTO postCreateDTO) {
        var post = postCreateDTO.toPost();

        postDAO.insertPost(post);

        ((ReviewPostCreateDTO)postCreateDTO).setPostId(post.getId());

        var reviewInfo = ((ReviewPostCreateDTO)postCreateDTO).toReviewInfo();

        postDAO.insertReviewInfo(reviewInfo);
    }

    @Override
    public void updatePost(Integer postId, PostUpdateDTO postUpdateDTO) {
        super.updatePost(postId, postUpdateDTO);

        var reviewInfo = ((ReviewPostUpdateDTO)postUpdateDTO).toReviewInfo(postId);

        postDAO.updateReviewInfo(reviewInfo);
    }

    @Override
    public void deletePost(Integer postId) {
        super.deletePost(postId);
        postDAO.deleteReviewInfo(postId);
    }
}
