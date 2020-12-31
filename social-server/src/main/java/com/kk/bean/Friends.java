package com.kk.bean;

import com.kk.bean.parent.Parent;

public class Friends extends Parent {
    private Integer user_id;
    private Integer friend_id;

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + super.getId() +
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                '}';
    }
    public Friends(){}
    public Friends(Integer id, Integer user_id, Integer friend_id) {
        super(id);
        this.user_id = user_id;
        this.friend_id = friend_id;
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
}
