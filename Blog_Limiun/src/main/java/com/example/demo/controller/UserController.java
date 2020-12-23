package com.example.demo.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisUtil;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultStatus;
import com.example.demo.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    private RedisUtil redisUtil = null;

    final static int OUTTIME = 30*60; //token的redis缓存半小时过期
    @PassToken
    @RequestMapping("/login")
    public Result checkUser(@RequestBody User user){
        User user1 = userService.getUserByAccount(user.getAccount());
        if (user1==null) return null;
        if (user.getPassword().equals(user1.getPassword())){
            String token = Token.getToken(user1);
            saveToken(user1.getAccount(),token,OUTTIME);
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


    /**
     *
     * @param key redis的key
     * @param value redis 的value
     * @param sec 缓存时间的秒数
     * @return
     */
    public boolean saveToken(String key,String value,int sec){
        try{
            Object v = redisUtil.get(key);
            /* 使用双重验证锁解决高并发环境下的缓存穿透问题 */
            if (StringUtils.isEmpty(v)){// 第一重验证
                synchronized (this){
                    v = redisUtil.get(key);
                    if (StringUtils.isEmpty(v)){// 第二重验证
                        System.out.println("查询数据库............");
                        // 缓存为空，则查询数据库将相关数据存储到redis中
                        redisUtil.set(key, value,sec); //10秒后过期
                        return true;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
