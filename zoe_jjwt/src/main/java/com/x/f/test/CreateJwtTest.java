package com.x.f.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author zoe
 * @date 2019-01-16
 */
public class CreateJwtTest {
    public static void main(String[] args) {
        /**
         * setIssuedAt  设置签发时间
         * signWith    设置签名秘钥
         */
        JwtBuilder jwtBuilder = Jwts.builder().setId("888")
                .setSubject("柒")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itCast");
        System.out.println(jwtBuilder.compact());
    }
}
