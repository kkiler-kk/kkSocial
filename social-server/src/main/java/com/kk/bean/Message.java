package com.kk.bean;

public class Message {
    private Integer msg_id;
    private Integer reception_id; //接收者ID
    private User user;   //发送者id
    private String content_text; //发送内容
    private Integer type; //类型 1 群聊 0私聊
    private String create_date; //发送时间
}
