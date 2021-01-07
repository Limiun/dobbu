package com.example.demo.service.impl;

import com.example.demo.bean.user.UserBean;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.SimpleMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean registUser(UserBean user) {
        user.setPassWord(SimpleMD5.getMe().getSimpleMD5(user.getPassWord()));
        if (user.getCardId()!=null){
            user.setCardId(SimpleMD5.getMe().getSimpleMD5(user.getCardId()));
        }
        userMapper.registUser(user);
        return false;
    }

    @Override
    public UserBean loginUser(String userName, String passWord) {
        String s = SimpleMD5.getMe().getSimpleMD5(passWord);
        userMapper.loginUser(userName,s);
        return null;
    }


}
