package com.x.f.dao;

import com.x.f.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author zoe
 * @date 2019-01-08
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 根据热门状态获取企业列表
     *
     * 面向对象的查询语句jphl。jphl类似于hql。hql是hibernate内部面向对象的查询语句
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);
}
