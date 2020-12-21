package com.kk.bean;

public class Friends {
    private Integer id;//逐渐
    private Integer user_id; //用户id

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                '}';
    }

    public  Friends(){}
    public Friends(Integer id, Integer user_id, Integer friend_id) {
        this.id = id;
        this.user_id = user_id;
        this.friend_id = friend_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }

    private Integer friend_id; //好友id
}
