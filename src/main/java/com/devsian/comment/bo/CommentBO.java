package com.devsian.comment.bo;

import com.devsian.comment.converter.CommentConverter;
import com.devsian.comment.dao.CommentDAO;
import com.devsian.comment.dto.CommentCreateDTO;
import com.devsian.comment.dto.CommentReadDTO;
import com.devsian.comment.dto.CommentUpdateDTO;
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

    public void create(CommentCreateDTO commentCreateDTO) {
        // converter
        var comment = CommentConverter.of(commentCreateDTO);
        commentDAO.insert(comment);
    }

    public void update(Integer commentId, CommentUpdateDTO commentUpdateDTO) {
        /*
           ToDo : userId 검증 단계. --> 해당 user가 comment를 작성했는지 확인.
         */
        var comment = CommentConverter.of(commentId, commentUpdateDTO);
        commentDAO.update(comment);
    }
}
