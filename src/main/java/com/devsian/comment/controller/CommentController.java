package com.devsian.comment.controller;

import com.devsian.comment.bo.CommentBO;
import com.devsian.comment.dto.CommentCreateDTO;
import com.devsian.comment.dto.CommentReadDTO;
import com.devsian.comment.dto.CommentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/v1.0/comment")
    public ResponseEntity<Void> writeComment(@RequestBody CommentCreateDTO commentCreateDTO) {
        commentBO.create(commentCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/v1.0/comment/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Integer commentId, @RequestBody CommentUpdateDTO commentUpdateDTO) {
        commentBO.update(commentId, commentUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/v1.0/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId) {
        commentBO.delete(commentId);
        return ResponseEntity.noContent().build();
    }
}
