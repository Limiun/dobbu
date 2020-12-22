package com.example.demo.utils;

public interface ResultStatus {
    /**
     * 成功
     */
    int SUCCESS = 1;
    /**
     * 参数错误（比如有参数为空）
     */
    int PARAMETERERROR = -1;
    /**
     * 签名错误
     */
    int SIGNERROR = -3;
    /**
     * 工单已存在（order_id 重复并且已经成功）
     */
    int ORDERAGAIN = -5;
    /**
     * 服务器不可用（已经开服）
     */
    int SERVEROPENED = -6;

    /**
     * 注册创建账号已存在
     */
    int EXISTACCOUNT = -7;
    /**
     * 注册时，向数据库插入数据失败
     */
    int INSERTSQLFAILD = -8;


    /**
     * 未知错误
     */
    int UNKNOWNERROR = -100;
}
