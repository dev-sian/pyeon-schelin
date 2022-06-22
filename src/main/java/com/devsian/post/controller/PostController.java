package com.devsian.post.controller;

import com.devsian.post.bo.PostFacade;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostFacade postFacade;

    @GetMapping("/posts/{boardId}")
    public ResponseEntity<List<PostReadDTO>> getList(@PathVariable Integer boardId){
        var postReadDTOList = postFacade.getAllPost(boardId);
        return ResponseEntity.ok(postReadDTOList);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostReadDTO> get(@PathVariable Integer postId){
        var postReadDTO = postFacade.getPost(postId);
        return ResponseEntity.ok(postReadDTO);
    }

    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@RequestBody PostCreateDTO postCreateDTO){
        postFacade.createPost(postCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Integer postId, @RequestBody PostUpdateDTO postUpdateDTO){
        postFacade.updatePost(postId, postUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId){
        postFacade.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}