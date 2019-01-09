package com.x.f.service;

import com.x.f.dao.CommentDao;
import com.x.f.entity.Comment;
import com.x.f.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zoe
 * @date 2019-01-09
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 增加
     * @param comment
     */
    public void add(Comment comment){
        comment.set_id(idWorker.nextId()+"");
        commentDao.save(comment);
    }

    /**
     * 根据文章id 查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }
}
