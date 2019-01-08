package com.x.f.dao;

import com.x.f.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zoe
 * @date 2019-01-08
 */
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    /**
     * 查询只用@Query   增删改必须加 @Modifying 可能产生线程问题
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true)
    public void examine(String id);

    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup = thumbup+1 WHERE id = ?", nativeQuery = true)
    public void updateThumbup(String id);
}
