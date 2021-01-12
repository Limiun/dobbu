package com.example.demo.controller.user;

import com.example.demo.bean.user.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("xxlogin")
public class LoginController {
    @Autowired
    public UserService userService;
    @CrossOrigin
    @PostMapping("/main")
    public UserBean loginUser(@RequestBody UserBean userBean){
        String userName = userBean.getUserName();
        String passWord = userBean.getPassWord();
        UserBean user = userService.loginUser(userName,passWord);
        return user;
    }

}
