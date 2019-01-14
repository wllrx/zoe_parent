package com.x.f.listener;

import com.aliyuncs.exceptions.ClientException;
import com.x.f.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zoe
 * @date 2019-01-14
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;//模板编号

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;//签名

    /**
     * 发送短信
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        String mobile = message.get("mobile");
        String code = message.get("code");
        System.out.println("手机号:"+message.get("mobile"));
        System.out.println("验证码:"+message.get("code"));
        try {
            smsUtil.sendSms(message.get("mobile"),template_code,sign_name,"{\"number\":\""+message.get("code")+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
