package com.x.f.dao;

import com.x.f.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zoe
 * @date 2019-01-08
 */
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    /**
     * nativeQuery = true 表示可以写sql语句  采用直接写sql语句的方式
     * Pageable pageable   spring data jpa 分页
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem WHERE id IN (SELECT problemid FROM tb_pl WHERE labelid=?) ORDER BY replytime DESC", nativeQuery = true)
    public Page<Problem> newList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem WHERE id IN (SELECT problemid FROM tb_pl WHERE labelid=?) ORDER BY reply DESC ", nativeQuery = true)
    public Page<Problem> hotList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem WHERE id IN (SELECT problemid FROM tb_pl WHERE labelid=?) AND reply=0 ORDER BY createtime DESC ", nativeQuery = true)
    public Page<Problem> waitList(String labelid, Pageable pageable);

    /**
     * 根据标签ID查询最新问题列表   面向对象的sql
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid=?1) order by replytime desc ")
    public Page<Problem> findNewListByLabelId(String labelId,Pageable pageable);

    /**
     * 根据标签id 查询热门问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid=?1) order by reply desc ")
    public Page<Problem> findHostListByLabelId(String labelId,Pageable pageable);

    /**
     * 根据id 查询等待回答列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid=?1) and reply = 0 order by createtime desc ")
    public Page<Problem> findWaitListByLabelId(String labelId,Pageable pageable);
}
