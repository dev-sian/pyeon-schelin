package com.devsian.post.controller;

import com.devsian.post.bo.PostApiBO;
import com.devsian.post.dto.PostReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostApiBO postApiBO;

    @GetMapping("/posts/{boardId}")
    public ResponseEntity<List<PostReadDTO>> getPosts(@PathVariable Integer boardId){
        var postReadDTOList = postApiBO.getAllPost(boardId);
        return ResponseEntity.ok(postReadDTOList);
    }
}
