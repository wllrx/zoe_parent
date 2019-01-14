package com.x.f.service;

import com.x.f.dao.ArticleSearchDao;
import com.x.f.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author zoe
 * @date 2019-01-11
 */
@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加
     * @param article
     */
    public void add(Article article){
        articleSearchDao.save(article);
    }

    /**
     * 检索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String keywords,int page,int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,pageRequest);
    }

}
