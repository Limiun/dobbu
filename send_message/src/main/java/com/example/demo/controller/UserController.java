package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.SimpleMD5;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedList;

@CrossOrigin
@RestController
@RequestMapping("/testBoot")
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("getUser1/{id}")
    public User send(@PathVariable int id){
        System.out.println(userService.GetUserNameAndPassWordAndSex(id).getUserName());
        System.out.println(userService.GetUserNameAndPassWordAndSex(id).getSex());
        System.out.println(userService.GetUserNameAndPassWordAndSex(id).getPassWord());
        return userService.GetUserNameAndPassWordAndSex(id);
    }
    @CrossOrigin
    @RequestMapping("checkUser")
    public boolean checkUser(@RequestBody User user){
        System.out.println("username:"+user.getUserName());
        return true;
    }
    @CrossOrigin
    @RequestMapping("loginPassWord")
    public boolean checkPassWord(@RequestBody User user , HttpServletRequest httpServletRequest, HttpServletResponse ht){
        User user1 = userService.GetPassWordByUserName(user.getUserName());
        if (user1 != null){
            if (user.getPassWord() == user1.getPassWord()){
                return true;
            }
        }
        System.out.println(SimpleMD5.getSimpleMD5(user.getPassWord()));
       return false;
    }

    @CrossOrigin
    @RequestMapping("loginUser")
    public User getUser(@RequestBody User user){
        User user1 = userService.GetUserByUserName(user.getUserName());
        if (user1 != null){
            if (user.getPassWord() == user1.getPassWord()){
                return user1;
            }
        }
        System.out.println(SimpleMD5.getSimpleMD5(user1.getPassWord()));
        return user1;
    }
}
