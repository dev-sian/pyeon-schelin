package com.devsian.comment.bo;

import com.devsian.comment.converter.CommentConverter;
import com.devsian.comment.dao.CommentDAO;
import com.devsian.comment.dto.CommentReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentBO {
    private final CommentDAO commentDAO;

    public List<CommentReadDTO> getAll(int postId, int offset) {
        var comments = commentDAO.selectAll(postId, offset);

        return comments.stream()
                .map(CommentConverter::of)
                .collect(Collectors.toList());
    }
}
