package com.kk.bean;

public class Message {
    private String sendName; //发送者
    private String createDate; //发送时间
    private String type; //消息类型
    private String url; //发送者头像
    private String receiveName; //接收者
    private String text; //发送内容
    public Message(){}
    public Message(String sendName, String createDate, String type, String url, String receiveName, String text) {
        this.sendName = sendName;
        this.createDate = createDate;
        this.type = type;
        this.url = url;
        this.receiveName = receiveName;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendName='" + sendName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
