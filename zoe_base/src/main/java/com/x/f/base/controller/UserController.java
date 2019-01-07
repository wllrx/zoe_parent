package com.x.f.base.controller;

import com.x.f.base.service.LabelService;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zoe
 * @date 2019-01-04
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class UserController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功" + labelService.findAll());
    }


}


