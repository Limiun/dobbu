package com.example.demo.utils;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimpleMD5 {
    public static String getSimpleMD5(String passWord){
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
