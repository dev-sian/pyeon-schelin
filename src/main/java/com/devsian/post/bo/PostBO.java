package com.devsian.post.bo;

import com.devsian.common.pagination.Pagination;
import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class PostBO {
    protected final PostDAO postDAO;

    public abstract List<PostReadDTO> getList(List<Post> posts);

    public abstract PostReadDTO get(Post post);

    public void create(Post post){
        postDAO.insertPost(post);
    }

    public void update(Post post){
        /*
         * TODO: writer 검증
         *  */
        postDAO.updatePost(post);
    }

    public void delete(Integer postId){
        /*
        * TODO: writer 검증
        *  */
        postDAO.deletePost(postId);
    }
}
