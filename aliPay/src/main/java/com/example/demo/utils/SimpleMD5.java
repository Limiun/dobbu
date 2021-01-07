package com.example.demo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimpleMD5 {
    private static SimpleMD5 simpleMD5;
    private static final Object lock_simpleMD5 = new Object();
    public static SimpleMD5 getMe(){
        if (simpleMD5!=null){
            synchronized (lock_simpleMD5){
                if (simpleMD5!=null){
                    simpleMD5 = new SimpleMD5();
                }
            }
        }
        return simpleMD5;
    }

    public String getSimpleMD5(String passWord){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算MD5函数
            md.update(passWord.getBytes());
            return new BigInteger(1,md.digest()).toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
