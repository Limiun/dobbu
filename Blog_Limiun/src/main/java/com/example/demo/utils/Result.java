package com.example.demo.utils;

import com.example.demo.bean.User;
import lombok.Data;

@Data
public class Result {
    private static final long serialVersionUID = 1L;
    private Integer code; // 状态码
    private String token; //token
    private String msg; //消息提示
    private String extend; //扩展
    private User user;

    public Result(Integer code, String token, String msg, String extend,User user) {
        this.code = code;
        this.token = token;
        this.msg = msg;
        this.extend = extend;
        this.user = user;
    }
}
