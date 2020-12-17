package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User SelectUser(long id);
    User GetUserByAccount(String account);
    int InsertUser(long id,String username,String account,String password,int sex ,int age,int phone,int account_state,String special_sign,long money,String extendMap);
}
