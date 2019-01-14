package com.x.f.dao;

import com.x.f.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zoe
 * @date 2019-01-14
 */
public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {

    public Admin findByLoginname(String loginname);
}
