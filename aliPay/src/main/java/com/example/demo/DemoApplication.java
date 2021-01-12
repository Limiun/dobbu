package com.example.demo;

import com.example.demo.bean.user.UserBean;
import com.example.demo.controller.user.RegistController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sun.plugin2.util.SystemUtil;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
