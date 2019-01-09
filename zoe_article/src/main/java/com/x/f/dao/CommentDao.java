package com.x.f.dao;

import com.x.f.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zoe
 * @date 2019-01-09
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章id 查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}
