package com.x.f.client;

import com.x.f.client.impl.BaseClientImpl;
import com.x.f.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zoe
 * @date 2019-01-08
 */
@FeignClient(value = "zoe-base" , fallback = BaseClientImpl.class)
public interface BaseClient {
    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
