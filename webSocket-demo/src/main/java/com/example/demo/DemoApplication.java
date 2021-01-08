package com.example.demo;


import com.example.demo.Cache.SaveCache;
import com.example.demo.bean.test;
import com.example.demo.utils.ExcelConvert;
import com.example.demo.utils.MyException;
import com.example.demo.utils.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        try {
            List<test> testList = ExcelConvert.getBean("F:\\test.xls",test.class);
            SaveCache.getMe().putCacheItem("test",testList);
            System.out.println(testList.size());
            System.out.println(testList);
        } catch (MyException e) {
            e.printStackTrace();
        }
        SpringApplication.run(DemoApplication.class,args);
        try {
            new NettyServer(12345).start();

        }catch(Exception e) {
            System.out.println("NettyServerError:"+e.getMessage());
        }

    }

}
