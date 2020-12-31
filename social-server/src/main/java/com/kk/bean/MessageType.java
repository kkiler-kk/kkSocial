package com.kk.bean;

import com.kk.bean.parent.Parent;

public class MessageType extends Parent {
    private Integer user_id; //用户ID
    private Integer friend_id; //好友ID
    private String content; //留言内容
    private int type; //消息类型 0 为系统消息 1 为 好友申请

    public MessageType(Integer message_id, Integer user_id, Integer friend_id, String content, int type) {
        super(message_id);
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.content = content;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageType{" +
                "message_id=" + super.getId() +
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
