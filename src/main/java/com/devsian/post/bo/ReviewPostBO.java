package com.devsian.post.bo;

import com.devsian.post.dao.ReviewPostDAO;
import com.devsian.post.dto.ReviewPostTotalReadDTO;
import com.devsian.post.entity.ReviewPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewPostBO {
    private final ReviewPostDAO reviewPostDAO;

    // 전체 리뷰 게시판 목록 조회.
    public List<ReviewPostTotalReadDTO> getPosts() {
        List<ReviewPost> reviewPosts = reviewPostDAO.selectAll();
        for(int i = 0; i < reviewPosts.size(); i++) {
            System.out.println(reviewPosts.get(i));
        }

        return reviewPosts.stream()
                .map(ReviewPostTotalReadDTO::new)
                .collect(Collectors.toList());
    }
}
