package com.devsian.post.controller;

import com.devsian.post.bo.PostApiBO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostApiBO postApiBO;

    @GetMapping("/posts/{boardId}")
    public ResponseEntity<List<PostReadDTO>> getPosts(@PathVariable Integer boardId){
        var postReadDTOList = postApiBO.getAllPost(boardId);
        return ResponseEntity.ok(postReadDTOList);
    }

    @PostMapping("/post")
    public ResponseEntity<PostReadDTO> createPost(@RequestBody PostCreateDTO postCreateDTO){
        var postReadDTO = postApiBO.createPost(postCreateDTO);
        return ResponseEntity.ok(postReadDTO);
    }
}
