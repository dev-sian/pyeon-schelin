package com.devsian.post.controller;

import com.devsian.post.bo.ReviewPostBO;
import com.devsian.post.dto.ReviewPostTotalReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewPostController {
    private final ReviewPostBO reviewPostBO;

    @GetMapping("/v1.0/review")
    public ResponseEntity<List<ReviewPostTotalReadDTO>> getReviewPosts() {
        var reviewPostTotalReadDTOList = reviewPostBO.getPosts();
        return ResponseEntity.ok(reviewPostTotalReadDTOList);
    }
}
