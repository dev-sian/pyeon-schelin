package com.devsian.post.controller;

import com.devsian.common.pagination.Pagination;
import com.devsian.post.bo.PostFacade;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostFacade postFacade;

    @GetMapping("/posts/{boardId}")
    public ResponseEntity<Pagination<PostReadDTO>> getList(@PathVariable Integer boardId, @RequestParam("page") Integer page, @RequestParam("listSizePerPage") Integer listSizePerPage){
        Pagination<PostReadDTO> postPagination = postFacade.getList(boardId, page, listSizePerPage);
        return ResponseEntity.ok(postPagination);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostReadDTO> get(@PathVariable Integer postId){
        var postReadDTO = postFacade.get(postId);
        return ResponseEntity.ok(postReadDTO);
    }

    @PostMapping("/posts")
    public ResponseEntity<Void> create(@RequestBody PostCreateDTO postCreateDTO){
        postFacade.create(postCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<Void> update(@PathVariable Integer postId, @RequestBody PostUpdateDTO postUpdateDTO){
        postFacade.update(postId, postUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Integer postId){
        postFacade.delete(postId);
        return ResponseEntity.noContent().build();
    }
}