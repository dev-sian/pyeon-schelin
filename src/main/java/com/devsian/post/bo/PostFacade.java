package com.devsian.post.bo;

import com.devsian.common.pagination.Pagination;
import com.devsian.post.PostType;
import com.devsian.post.dao.PostDAO;
import com.devsian.post.dto.PostCreateDTO;
import com.devsian.post.dto.PostReadDTO;
import com.devsian.post.dto.PostUpdateDTO;
import com.devsian.post.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostFacade {
    private final PostDAO postDAO;
    private final GeneralPostBO generalPostBO;
    private final ReviewPostBO reviewPostBO;

    public Pagination<PostReadDTO> getList(Integer boardId, Integer page, Integer listSizePerPage){
        Pagination<PostReadDTO> postPagination = new Pagination<>();

        Integer offset = postPagination.calcOffset(page, listSizePerPage);

        var posts = postDAO.selectAllPosts(boardId, listSizePerPage, offset);

        Post post = posts.stream()
                .findAny()
                .orElse(null);

        PostBO postBO = getPostBO(post);

        List<PostReadDTO> list = postBO.getList(posts);

        postPagination.setList(list);
        postPagination.setTotalListSize(postDAO.selectCount(boardId));

        return postPagination;
    }

    public PostReadDTO get(Integer postId){
        var post = postDAO.selectPost(postId);

        PostBO postBO = getPostBO(post);

        return postBO.get(post);
    }

    public void create(PostCreateDTO postCreateDTO){
        var post = postCreateDTO.toPost();

        PostBO postBO = getPostBO(post);

        postBO.create(post);
    }

    public void update(Integer postId, PostUpdateDTO postUpdateDTO){
        var post = postUpdateDTO.toPost(postId);

        PostBO postBO = getPostBO(post);

        postBO.update(post);
    }

    public void delete(Integer postId){
        // PostType을 구하기 위해 postId로 디비 조회
        var post = postDAO.selectPost(postId);

        PostBO postBO = getPostBO(post);

        postBO.delete(postId);
    }

    PostBO getPostBO(Post post){
        PostType postType = post.getPostType();
        PostBO postBO = null;

        switch(postType){
            case GENERAL_POST:
                postBO = generalPostBO;
                break;
            case REVIEW_POST:
                postBO = reviewPostBO;
                break;
            default:
                log.error("없는 post type");
                break;
        }

        return postBO;
    }
}
