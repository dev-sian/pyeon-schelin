package com.devsian.comment.controller;

import com.devsian.comment.bo.CommentBO;
import com.devsian.comment.dto.CommentReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentBO commentBO;

    @GetMapping("/v1.0/comments/{postId}")
    public ResponseEntity<List<CommentReadDTO>> getComments(@RequestParam("offset") int offset, @PathVariable("postId") int postId) {
        // offset : queryString (@RequestParam), postId : pathParameter (@PathVariable)
        var commentReadDTO = commentBO.getAll(postId, offset);
        return ResponseEntity.ok(commentReadDTO);
    }
}
