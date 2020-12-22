package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.bean.User;

import sun.plugin2.util.SystemUtil;

import java.util.Date;

public class Token {
    private final static String SPECIAL = "Limiun";
    public static String getToken(User user){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public static int getId(){
        long time = System.currentTimeMillis();
        int t = (int) (time/1000);
        return t;

    }
}
