package com.x.f.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听kudingyu消息
 * @author zoe
 * @date 2019-01-14
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("kudingyu收到消息:"+message);
    }
}
