package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;
import org.json.JSONException;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/redis")
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

//    @Autowired
    @Resource
    private RedisUtil redisUtil = null;

    @Autowired
    private JedisUtil jedisUtil = null;

    @RequestMapping(value = "/test1")
    @ResponseBody
    public void t(){
        test();
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public Map<String, Object> test() throws JSONException {
        //System.out.printf("ip: %s port: %s password: %s ", redisHost, redisPort, redisPassword);

        //jedis操作
        //jedisUtil.set("lisi", "李四");
        //redis template操作redis
        //redisUtil.set("zhangsan", "张三");

        /**
         * Jedis是Redis官方推荐的面向Java的操作Redis的客户端，
         *
         * RedisTemplate是SpringDataRedis中对JedisApi的高度封装。
         * SpringDataRedis相对于Jedis来说可以方便地更换Redis的Java客户端，比Jedis多了自动管理连接池的特性，
         * 方便与其他Spring框架进行搭配使用如：SpringCache支持 jedis和lettuce
         **/


        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Object zhangsan = redisUtil.get("zhangsan");
            //System.out.println("zhangsan" + zhangsan);
            /* 使用双重验证锁解决高并发环境下的缓存穿透问题 */
            if (StringUtils.isEmpty(zhangsan)) { // 第一重验证
                synchronized (this) {
                    zhangsan = redisUtil.get("zhangsan");
                    if (StringUtils.isEmpty(zhangsan)) { // 第二重验证
                        System.out.println("查询数据库............");
                        // 缓存为空，则查询数据库将相关数据存储到redis中
                        redisUtil.set("zhangsan", "张三",10); //10秒后过期
                    } else {
                        System.out.println("2 查询缓存............");
                    }
                }
            } else {
                System.out.println("1 查询缓存............");
            }

            map.put("success", true);

            ////entity实体类
            //User user = new User();
            //user.setUserId(1000);
            //user.setUserName("张三");
            //user.setAddress("深圳市南山区");
            //user.setMobile("13988886666");
            //redisUtil.set("userInfo", user.toString(), 10);  //10秒后过期自动删除
            ////获取显示
            //String str = String.valueOf(redisUtil.get("userInfo"));
            //JSONObject jsonObj = new JSONObject(str);
            //map.put("userInfo", jsonObj.get("userId"));
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        } finally {
        }
        return map;
    }

    /**
     * 操作redis字符串和hash散列
     *
     * @return
     * @Date 2018年11月1日 下午1:56:30
     * @Author lay
     */
    @RequestMapping(value = "/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash() {
        //set字符串
        redisTemplate.opsForValue().set("key1", "value1");
        System.out.println("-------------set字符串-------------------: " + redisTemplate.opsForValue().get("key1"));

        //定义一个hashmap散列
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        System.out.println("-------------存入一个散列数据类型-------------------: ");


        System.out.println("-------------map 遍历-------------------: ");
        redisTemplate.opsForHash().entries("hash").forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        System.out.println("-------------map->set 遍历-------------------: ");
        redisTemplate.opsForHash().keys("hash").forEach(key -> {
            System.out.println(key + ": " + redisTemplate.opsForHash().get("hash", key));
        });


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        return map;
    }
}