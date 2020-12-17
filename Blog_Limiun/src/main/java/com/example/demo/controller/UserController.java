package com.example.demo.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PassToken
    @RequestMapping("/login")
    public User checkUser(@RequestBody User user){
        User user1 = userService.getUserByAccount(user.getAccount());
        return user1;

    }

    @PassToken
    @RequestMapping("/regist")
    public boolean insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

}
