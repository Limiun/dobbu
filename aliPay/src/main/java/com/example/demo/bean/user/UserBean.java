package com.example.demo.bean.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Accessors(chain = true)
public class UserBean {
    //id
    private int id;
    //用户名
    private String userName;
    //密码
    private String passWord;
    //性别
    private int sex;
    //身份证号
    private String cardId;
    //邮箱
    private String email;
    //注册时间
    private long startDate;
    //电话
    private long phone;
    //扩展信息
    private String extendMap;

}
