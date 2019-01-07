package com.x.f.base.dao;

import com.x.f.base.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zoe
 * @date 2019-01-04
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
