package com.x.f.dao;

import com.x.f.entity.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zoe
 * @date 2019-01-08
 */
public interface ColumnDao extends JpaRepository<Column,String>, JpaSpecificationExecutor<Column> {
}
