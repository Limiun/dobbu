package com.example.demo.service;

import com.example.demo.bean.user.UserBean;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //注册
     boolean registUser(UserBean user);
    //登录
    UserBean loginUser(String userName,String passWord);
}
