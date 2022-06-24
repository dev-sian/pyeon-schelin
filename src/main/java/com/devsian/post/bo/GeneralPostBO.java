package com.devsian.post.bo;

import com.devsian.common.pagination.Pagination;
import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.GeneralPostReadDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralPostBO extends PostBO{

    @Autowired
    public GeneralPostBO(PostDAO postDAO) {
        super(postDAO);
    }

    @Override
    public List<PostReadDTO> getList(List<Post> posts) {
        return posts.stream()
                .map(GeneralPostReadDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PostReadDTO get(Post post) {
        return new GeneralPostReadDTO(post);
    }

    @Override
    public void create(Post post) {
        super.create(post);
    }

    @Override
    public void update(Post post) {
        super.update(post);
    }

    @Override
    public void delete(Integer postId) {
        super.delete(postId);
    }
}
