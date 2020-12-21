package com.kk.bean;

import java.util.List;

public class User {
    private Integer id;//id
    private String email;//邮箱
    private String password;//密码
    private String name;//姓名
    private Integer gender;//性别
    private List<User> friendsList;//好友列表

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }


    public User(){

    }

    public User(Integer id, String email, String password, String name, Integer gender) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }


}
