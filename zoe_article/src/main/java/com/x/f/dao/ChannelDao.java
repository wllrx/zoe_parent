package com.x.f.dao;

import com.x.f.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zoe
 * @date 2019-01-08
 */
public interface ChannelDao extends JpaRepository<Channel,String>, JpaSpecificationExecutor<Channel> {

}
