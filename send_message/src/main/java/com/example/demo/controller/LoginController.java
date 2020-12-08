package com.example.demo.controller;

import com.example.demo.annotation.UserLoginToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.SimpleMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @UserLoginToken
    @CrossOrigin
    @RequestMapping("index")
    public int checkLogin(@RequestBody User user) {
        User targetUser = userService.GetUserByUserName(user.getUserName());
        if ( SimpleMD5.getSimpleMD5(targetUser.getPassWord()).equals(SimpleMD5.getSimpleMD5(user.getPassWord())) ) {
           return 1;
        }
        return 0;
    }

    @CrossOrigin
    @RequestMapping("regist")
    public boolean InsertUser(@RequestBody User user){
        boolean result = userService.InsertUser(user);
        return result;
    }
}
