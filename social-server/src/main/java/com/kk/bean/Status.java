package com.kk.bean;

import com.kk.bean.parent.Parent;

import java.io.Serializable;

public class Status<T> extends Parent implements Serializable {
    private String type; //消息类型
    private Boolean flag; //点赞 true false
    private Integer user_id; //用户id
    private T data; //主要对象
    public Status(){}
    public Status(T data){
        this.data = data;
    }
    public Status(Integer id){
        super(id);
    }
    public Status(Integer id,Boolean flag) {
        super(id);
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Status{" +
                "type='" + type + '\'' +
                ", flag=" + flag +
                ", user_id=" + user_id +
                '}';
    }
}
