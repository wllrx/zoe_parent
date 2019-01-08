package com.x.f.client.impl;

import com.x.f.client.BaseClient;
import com.x.f.entity.Result;
import com.x.f.entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author zoe
 * @date 2019-01-08
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"熔断器触发了");
    }
}
