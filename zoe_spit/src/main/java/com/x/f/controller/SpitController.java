package com.x.f.controller;

import com.x.f.entity.PageResult;
import com.x.f.entity.Result;
import com.x.f.entity.Spit;
import com.x.f.entity.StatusCode;
import com.x.f.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zoe
 * @date 2019-01-09
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(id));
    }

    /**
     * 增加
     * @param spit
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Spit spit){
        spitService.add(spit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param spit
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Spit spit,@PathVariable String id){
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id){
        spitService.deleteById(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    /**
     * 根据上级id查询吐槽分页数据
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/comment/{parentId}/{page}/{size}")
    public Result findByParentid(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){
        Page<Spit> pageList = spitService.findByParentid(parentid,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pageList.getTotalElements(),pageList.getContent()));
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PutMapping("/thumbup/{id}")
    public Result updateThumbup(@PathVariable String id){
        String userid ="11111";
        //判断当前用户是否已经点赞
        if (redisTemplate.opsForValue().get("spit_"+userid+"_"+id)!=null){
            return new Result(false,StatusCode.REPERROR,"不能重复点赞");
        }
        spitService.updateThumbup(id);
        //数据存入redis
        redisTemplate.opsForValue().set("spit_"+userid+"_"+id,1);
        return new Result(true,StatusCode.OK,"点赞成功");
    }


}
