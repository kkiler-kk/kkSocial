package com.kk.bean;

import com.kk.bean.parent.Parent;

public class MessageType extends Parent {
    private Integer user_id; //用户ID
    private User friend;
    private String content; //留言内容
    public MessageType(){}
    public MessageType(Integer message_id, Integer user_id, User friend, String content, int type) {
        super(message_id);
        this.user_id = user_id;
        this.friend = friend;
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageType{" +
                "message_id=" + super.getId() +
                ", user_id=" + user_id +
                ", friend_id=" + friend +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend_id(User friend) {
        this.friend = friend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
