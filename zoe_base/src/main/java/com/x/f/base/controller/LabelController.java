package com.x.f.base.controller;

import com.x.f.base.entity.Label;
import com.x.f.base.service.LabelService;
import com.x.f.entity.PageResult;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @CrossOrigin用于解决跨域调用   这个注解其实是CORS 的实现
 * CORS(Cross-Origin Resource Sharing,跨域资源共享)是W3C出的一个标准,其思想是使用自定义的HTTP头部让浏览器
 * 与服务器进行沟通,从而决定请求或响应是应该成功还是失败.因此,要想实现实现CORS进行跨域,需要对服务器进行一些设置,同时
 * 前端也需要做一些配置和分析.
 *
 * @author zoe
 * @date 2019-01-04
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功" , labelService.findAll());
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", labelService.findById(id));
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

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @PostMapping(value = "/search")
    public Result findSearch(@RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findSearch(searchMap));
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result pageQuery(@RequestBody Map searchMap,@PathVariable int page, @PathVariable int size){
        Page<Label> pageList = labelService.pageQuery(searchMap,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageList.getTotalElements(),pageList.getContent()));
    }

}


