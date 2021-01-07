package com.example.demo.mapper;

import com.example.demo.bean.user.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean registUser(UserBean userBean);
    UserBean loginUser(String userName,String passWord);
}
