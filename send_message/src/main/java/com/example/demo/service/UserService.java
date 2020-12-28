package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.SimpleMD5;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public User GetUserNameAndPassWordAndSex(int id){
        return userMapper.GetUserNameAndPassWordAndSex(id);
    }

    public User GetPassWordByUserName(String userName){
        return userMapper.GetPassWordByUserName(userName);
    }

    public User GetUserByUserName(String userName){
        return userMapper.GetUserByUserName(userName);
    }

    public boolean InsertUser(User user){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        int sex = user.getSex();
        String email = user.getEmail();
        String phone = user.getPhone();
        Map<String,Object> map = new HashMap<>();
        map.put("email",email);
        map.put("phone",phone);
        String extendMap = JSONObject.toJSONString(map);
        try {
            String Md5=SimpleMD5.getSimpleMD5(passWord);
            userMapper.InsertUser(userName,Md5,sex,extendMap);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
