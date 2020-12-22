package com.example.demo.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultStatus;
import com.example.demo.utils.Token;
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
    public Result checkUser(@RequestBody User user){
        User user1 = userService.getUserByAccount(user.getAccount());
        if (user1==null) return null;
        if (user.getPassword().equals(user1.getPassword())){
            String token = Token.getToken(user1);
//            RedisUtil.getjedis().hmset("token",)
            return new Result(ResultStatus.SUCCESS,token,"success",null,user);
        }
        return null;
    }

    @PassToken
    @RequestMapping("/user1")
    public Result insertUser(@RequestBody User user){
        user.setId(Token.getId());
        System.out.println(user.toString());
        Result result =  userService.insertUser(user);
        return result;
    }
}
