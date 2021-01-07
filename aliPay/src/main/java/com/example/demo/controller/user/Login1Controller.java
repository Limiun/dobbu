package com.example.demo.controller.user;

import com.example.demo.bean.user.UserBean;


import com.example.demo.config.aliPay.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login1Controller {

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody UserBean user) {

        String username = user.getUserName();
        String password = user.getPassWord();
        if (username.equals("codeduck") || password.equals("123123")){
            return new Result(200);
        }else {
            return new Result(400);
        }
    }
}