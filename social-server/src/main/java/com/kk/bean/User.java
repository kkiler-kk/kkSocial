package com.kk.bean;

import com.kk.bean.parent.Parent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "用户类")
public class User extends Parent {
    @ApiModelProperty(value = "邮箱")
    private String email;//邮箱
    @ApiModelProperty(value = "密码")
    private String password;//密码
    @ApiModelProperty("姓名")
    private String name;//姓名
    @ApiModelProperty("性别: 0 女 1 男")
    private Integer gender;//性别
    @ApiModelProperty("好友列表")
    private List<User> friendsList;//好友列表
    @ApiModelProperty("好友总数")
    private Integer countFriends; //好友总数
    @ApiModelProperty("头像路径")
    private String url;  //头像路径
    @ApiModelProperty("用户动态")
    private List<News> newsList;
    @ApiModelProperty("动态总数")
    private Integer countNews;
    @ApiModelProperty("粉丝总数")
    private Integer countFans;
    @ApiModelProperty("粉丝列表")
    private List<User> fansList;
    @ApiModelProperty("关注总数")
    private Integer countUser;
    @ApiModelProperty("关注列表")
    private List<User> userList;

    public User(){

    }
    public User( String email, String password, String name, Integer gender,String url) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", friendsList=" + friendsList +
                ", countFriends=" + countFriends +
                ", url='" + url + '\'' +
                ", newsList=" + newsList +
                ", countNews=" + countNews +
                ", countFans=" + countFans +
                ", fansList=" + fansList +
                ", countUser=" + countUser +
                ", userList=" + userList +
                '}';
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

    public Integer getCountFriends() {
        return countFriends;
    }

    public void setCountFriends(Integer countFriends) {
        this.countFriends = countFriends;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Integer getCountNews() {
        return countNews;
    }

    public void setCountNews(Integer countNews) {
        this.countNews = countNews;
    }

    public Integer getCountFans() {
        return countFans;
    }

    public void setCountFans(Integer countFans) {
        this.countFans = countFans;
    }

    public List<User> getFansList() {
        return fansList;
    }

    public void setFansList(List<User> fansList) {
        this.fansList = fansList;
    }

    public Integer getCountUser() {
        return countUser;
    }

    public void setCountUser(Integer countUser) {
        this.countUser = countUser;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
