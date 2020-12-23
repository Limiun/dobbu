package com.example.demo.controller;

import com.example.demo.utils.JedisUtil;
import com.example.demo.utils.RedisUtil;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

@Controller
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);
    private static RedisController s_me;
    private static final Object s_lockobj = new Object();

    public static RedisController getMe(){
        if (s_me == null){
            synchronized (s_lockobj){
                if (s_me == null){
                    s_me = new RedisController();
                }
            }
        }
        return s_me;
    }

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @Autowired
    private RedisUtil redisUtil = null;

    @Autowired
    private JedisUtil jedisUtil = null;

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
                    if (StringUtils.isEmpty(key)){// 第二重验证
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

    public String getToken(String key){
        Object v = redisUtil.get(key);
        if (StringUtils.isEmpty(v)){// 第一重验证
            synchronized (this){
                v = redisUtil.get(key);
                if (StringUtils.isEmpty(key)){
                    return null;
                }
            }
        }
        return String.valueOf(v);
    }

}
