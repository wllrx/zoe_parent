package com.x.f.controller;

import com.x.f.entity.Comment;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import com.x.f.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zoe
 * @date 2019-01-09
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Result save(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK,"提交成功");
    }

    @GetMapping("/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true,StatusCode.OK,"查询成功",commentService.findByArticleid(articleid));
    }
}
