package com.x.f.base.controller;

import com.x.f.base.entity.Label;
import com.x.f.base.service.LabelService;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @CrossOrigin用于解决跨域调用
 *
 * @author zoe
 * @date 2019-01-04
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class UserController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功" + labelService.findAll());
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功"+ labelService.findById(id));
    }

    /**
     * 添加标签
     * @param label
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /**
     * 根据id 修改标签
     * @param label
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    public Result update(@RequestBody Label label,@PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 根据id 删除标签
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}


