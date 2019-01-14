package com.x.f.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * 监听类  用于监听itheima
 * @author zoe
 * @date 2019-01-14
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itheima收到消息:"+message);
    }
}
