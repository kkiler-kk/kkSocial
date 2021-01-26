package com.kk.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author kk
 * @Date 2021/1/22
 */
@ApiModel(value = "用户信息类")
public class UserInfo implements Serializable {
    @ApiModelProperty("好友列表")
    private List<User> friendsList;//好友列表
    @ApiModelProperty("好友总数")
    private Integer countFriends; //好友总数
    @ApiModelProperty("用户动态")
    private List<News> newsList;
    @ApiModelProperty("动态总数")
    private Integer count_news;
    @ApiModelProperty("粉丝总数")
    private Integer count_fans;
    @ApiModelProperty("粉丝列表")
    private List<User> fansList;
    @ApiModelProperty("关注总数")
    private Integer count_user;
    @ApiModelProperty("关注列表")
    private List<User> userList;
    public UserInfo(){}

    @Override
    public String toString() {
        return "UserInfo{" +
                "countFriends=" + countFriends +
                ", count_news=" + count_news +
                ", count_fans=" + count_fans +
                ", count_user=" + count_user +
                '}';
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

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Integer getCount_news() {
        return count_news;
    }

    public void setCount_news(Integer count_news) {
        this.count_news = count_news;
    }

    public Integer getCount_fans() {
        return count_fans;
    }

    public void setCount_fans(Integer count_fans) {
        this.count_fans = count_fans;
    }

    public List<User> getFansList() {
        return fansList;
    }

    public void setFansList(List<User> fansList) {
        this.fansList = fansList;
    }

    public Integer getCount_user() {
        return count_user;
    }

    public void setCount_user(Integer count_user) {
        this.count_user = count_user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
