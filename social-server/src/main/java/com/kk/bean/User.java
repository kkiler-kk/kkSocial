package com.kk.bean;

import com.kk.bean.parent.Parent;

import java.util.List;

public class User extends Parent {
    private String email;//邮箱
    private String password;//密码
    private String name;//姓名
    private Integer gender;//性别
    private List<User> friendsList;//好友列表
    private int countFriends; //好友总数
    private String url;  //头像路径
    private List<News> newsList;
    public User(){

    }
    public User( String email, String password, String name, Integer gender,String url) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.url = url;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
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

    public int getCountFriends() {
        return countFriends;
    }

    public void setCountFriends(int countFriends) {
        this.countFriends = countFriends;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", countFriends=" + countFriends +
                ", url='" + url + '\'' +
                '}';
    }
}
