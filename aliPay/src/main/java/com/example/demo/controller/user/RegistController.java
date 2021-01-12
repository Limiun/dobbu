package com.example.demo.controller.user;


import com.example.demo.bean.user.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin

@RequestMapping("/api")
public class RegistController {
    @Autowired
    private UserService userService;


    @PostMapping("regist")
    public boolean registUser(@RequestBody UserBean user){
        if (user!=null){
            boolean result = userService.registUser(user);
            return result;
        }else {
            System.out.println("传入的user为空");
            return false;
        }
    }
}
