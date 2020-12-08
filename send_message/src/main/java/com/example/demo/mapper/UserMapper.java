package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(int id);
    User GetUserNameAndPassWordAndSex(int id);
    User GetPassWordByUserName(String userName);
    User GetUserByUserName(String userName);
    void InsertUser(String userName,String passWord,int sex,String extendMap);
}
