package com.x.f.service;

import com.x.f.dao.SpitDao;
import com.x.f.entity.Spit;
import com.x.f.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zoe
 * @date 2019-01-09
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有
     *
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }


    /**
     * 修改
     *
     * @param spit
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentid(String parentid, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageRequest);
    }

    /**
     * 点赞
     *
     * @param id
     */
    public void updateThumbup(String id) {
        /**
         * 方式一
         * 此方法执行效率不高,这个方法是查询出所有的字段,修改一个字段,在更新所有字段
         */
      /*  Spit spit = spitDao.findById(id).get();
        spit.setThumbup(spit.getThumbup()+1);
        spitDao.save(spit);*/

        /**
         * 存储过程和存储函数的优势?
         * 存储过程相当于把业务逻辑写到数据库端
         * 加入java端有一个业务逻辑需要十次数据库操作,那么正常情况下需要连接数据库十次
         * 数据库连接频繁意味着效率低下.
         * 如果用存储过程吧业务逻辑写到数据库端,只需要连接一次数据库就可以完成十次操作
         * 默认情况下存储过程无法并发,但是可以优化
         * 而且存储过程和存储函数使用的编程语言是pl/sql是面向过程的,维护起来特别麻烦
         */

        /**
         * 方式二
         * 使用MongoTemplate类实现对某列的操作  inc对数字进行加减 只能整型 长整型  双精度  浮点型
         */
        //封装查询条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //封装修改的数据内容
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }

    /**
     * 发布吐槽,吐槽评论
     * @param spit
     */
    public void add(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());//发布日期
        spit.setVisits(0);//浏览量
        spit.setShare(0);//分享量
        spit.setThumbup(0);//点赞数
        spit.setComment(0);//回复数
        spit.setState("1");//状态
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {//判断是否存在上级 id ,存在,评论
            //给父节点吐槽的回复数加一
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        spitDao.save(spit);
    }

}


