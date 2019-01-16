package com.x.f.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author zoe
 * @date 2019-01-16
 */
public class CreateJwtTest2 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();//当前时间
        long exp = now + 1000*60;//过期时间为一分钟
        JwtBuilder jwtBuilder = Jwts.builder().setId("888")
                .setSubject("柒")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itCast")
                .setExpiration(new Date(exp))//设置过期时间
                .claim("roles","admin")
                .claim("logo","log.png");
        System.out.println(jwtBuilder.compact());
    }
}
