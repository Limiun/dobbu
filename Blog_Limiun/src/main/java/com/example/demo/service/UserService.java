package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.utils.Result;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getUserById(int id);
    public User getUserByAccount(String account);
    public Result insertUser(User user);
}
