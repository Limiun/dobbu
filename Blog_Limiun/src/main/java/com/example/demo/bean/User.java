package com.example.demo.bean;

import lombok.Data;

import java.util.HashMap;

@Data
public class User {
    private long uid; //id
    private String uname;//用户名
    private String account;//账号
    private String sex;//性别
    private String age;//年龄
    private int account_state;//账号状态
    private String special_sign;//特殊码（用于邀请人家的标识）
    private long money;//
    private String extendMap;//扩展的String

}
