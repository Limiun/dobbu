package com.example.demo.bean;


/**
 * 登录用的用户信息类
 */

public class User {
    //用户id
    private int id;
    //用户登录账号
    private String userName;
    //密码
    private String passWord;
    //性别
    private int sex;
    //扩展信息Map<String,Object>
    private String extendMap;

    //扩展信息内容，仅暂时使用，暂存至extendMap里面
    private transient String email;

    private transient String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getExtendMap() {
        return extendMap;
    }

    public void setExtendMap(String extendMap) {
        this.extendMap = extendMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", extendMap='" + extendMap + '\'' +
                '}';
    }

}
