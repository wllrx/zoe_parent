package com.x.f.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zoe
 * @date 2019-01-16
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLmn5IiLCJpYXQiOjE1NDc2MjcyOTksImV4cCI6MTU0NzYyNzM1OX0.ucCgmx0B0B4vmbOM4vOtC0A82vLsL1W04OdwXAN76nM";
        Claims claims = Jwts.parser().setSigningKey("itCast").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间:"+simpleDateFormat.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+simpleDateFormat.format(claims.getExpiration()));
        System.out.println("当前时间:"+simpleDateFormat.format(new Date()));

    }
}
