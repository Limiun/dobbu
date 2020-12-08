package com.example.demo.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class testController {

    @Autowired
    UserService userService;

    @PassToken
    @RequestMapping("/test")
    public String test(@RequestBody User user){
        User targetUser = userService.GetUserByUserName(user.getUserName());
        System.out.println(targetUser);
        User u = new User();
        u.setId((int) (Math.random()*100));
        u.setUserName(user.getUserName());
        u.setPassWord(user.getPassWord());
        String token = Token.getToken(u);
        return token;
    }
}
