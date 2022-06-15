package com.devsian.post.bo;

import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.ReviewPostCreateDTO;
import com.devsian.post.dto.ReviewPostReadDTO;
import com.devsian.post.entity.Post;
import com.devsian.post.entity.ReviewInfo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReveiwPostBO extends PostBO{

    private final PostDAO postDAO;

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
    public PostReadDTO createPost(PostCreateDTO postCreateDTO) {
        var post = postCreateDTO.toPost();

        postDAO.insertPost(post);

        ((ReviewPostCreateDTO)postCreateDTO).setPostId(post.getId());

        var reviewInfo = ((ReviewPostCreateDTO)postCreateDTO).toReviewInfo();

        postDAO.insertReviewInfo(reviewInfo);

        return new ReviewPostReadDTO(post, reviewInfo);
    }
}
