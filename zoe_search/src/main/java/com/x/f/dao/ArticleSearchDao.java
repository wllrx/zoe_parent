package com.x.f.dao;

import com.x.f.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author zoe
 * @date 2019-01-11
 */
public interface ArticleSearchDao extends ElasticsearchCrudRepository<Article,String> {

    /**
     * 检索
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
