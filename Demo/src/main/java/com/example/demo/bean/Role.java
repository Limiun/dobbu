package com.example.demo.bean;

import lombok.Data;

@Data
public class Role {
    private int id;
    private String name;
    private String token;
    private String password;
    private long dateTime;
}
