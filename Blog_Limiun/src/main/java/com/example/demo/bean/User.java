package com.example.demo.bean;

import lombok.Data;

import java.util.HashMap;

@Data
public class User {
    private int id; //id
    private String username;//用户名
    private String account;//账号
    private String password;
    private int sex;//性别
    private int age;//年龄
    private long phone;
    private int account_state;//账号状态
    private String special_sign;//特殊码（用于邀请人家的标识）
    private long money;//
    private String extendMap;//扩展的String
}
