package com.x.f.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 直接模式
 * @author zoe
 * @date 2019-01-11
 */
@Component
@RabbitListener(queues = "itCast")
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itCast接收到信息:"+message);
    }
}
