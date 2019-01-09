package com.x.f.dao;

import com.x.f.entity.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zoe
 * @date 2019-01-09
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    /**
     * 根据上级ID 查询吐槽列表 分页
     * @param parentid
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
