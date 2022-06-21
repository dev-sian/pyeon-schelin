package com.devsian.post.controller;

import com.devsian.post.bo.PostFacade;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostFacade postFacade;

    @GetMapping("/posts/{boardId}")
    public ResponseEntity<List<PostReadDTO>> getPosts(@PathVariable Integer boardId){
        var postReadDTOList = postFacade.getAllPost(boardId);
        return ResponseEntity.ok(postReadDTOList);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostReadDTO> getPost(@PathVariable Integer postId){
        var postReadDTO = postFacade.getPost(postId);
        return ResponseEntity.ok(postReadDTO);
    }

    @PostMapping("/post")
    public ResponseEntity<Void> createPost(@RequestBody PostCreateDTO postCreateDTO){
        var postReadDTO = postFacade.createPost(postCreateDTO);
        return ResponseEntity.noContent().build();
    }
}