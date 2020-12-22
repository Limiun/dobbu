package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.SelectUser(id);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.GetUserByAccount(account);
    }

    @Override
    public Result insertUser(User user) {
        User u = userMapper.GetUserByAccount(user.getAccount());
        if (u!=null){
            return new Result(ResultStatus.EXISTACCOUNT,null,"注册创建账号已存在",null,null);
        }
        int id = user.getId();
        String username = user.getUsername();
        String account = user.getAccount();
        String password = user.getPassword();
        int sex = user.getSex();
        int age = user.getAge();
        long phone = user.getPhone();
        int account_state = user.getAccount_state();
        String special_sign = user.getSpecial_sign();
        long money = user.getMoney();
        String extendMap = user.getExtendMap();
        int insertnum = userMapper.InsertUser(id,username,account,password,sex,age,phone,account_state,special_sign,money,extendMap);
        if (insertnum>0) return new Result(ResultStatus.SUCCESS,null,"success",null,null);
        return new Result(ResultStatus.INSERTSQLFAILD,null,"注册时，向数据库插入数据失败",null,null);
    }
}
