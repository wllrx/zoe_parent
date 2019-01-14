package com.x.f.controller;

import com.x.f.entity.Article;
import com.x.f.entity.PageResult;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import com.x.f.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author zoe
 * @date 2019-01-11
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    /**
     * 增加
     * @param article
     * @return
     */
    @PostMapping
    public Result save(Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK,"增加成功");
    }

    /**
     * 搜索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/{keywords}/{page}/{size}")
    public Result findByTitleLike(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){

        Page<Article> articlePage = articleSearchService.findByTitleOrContentLike(keywords, page, size);

        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(articlePage.getTotalElements(),articlePage.getContent()));
    }
}
