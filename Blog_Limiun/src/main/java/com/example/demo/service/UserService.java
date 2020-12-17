package com.example.demo.service;

import com.example.demo.bean.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getUserById(long id);
    public User getUserByAccount(String account);
    public boolean insertUser(User user);
}
