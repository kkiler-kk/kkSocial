package com.kk.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kk.bean.parent.Parent;

public class News extends Parent {

    private User user; //用户
    private String create_date; //发布时间
    private String content_text; //发布内容
    @JsonInclude(JsonInclude.Include.NON_NULL) //为null时不返回
    private String picture; //图片
    private Integer comment_num; //评论人数
    private Integer share_num; //分享人数
    private Integer like; //点赞总数
    private String tag;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public News(){}

    public News(Integer new_id, User user, String create_date, String content_text, String picture, Integer comment_num, Integer share_num, Integer like) {
        super(new_id);
        this.user = user;
        this.create_date = create_date;
        this.content_text = content_text;
        this.picture = picture;
        this.comment_num = comment_num;
        this.share_num = share_num;
        this.like = like;
    }

    @Override
    public String toString() {
        return "News{" +
                ", create_date='" + create_date + '\'' +
                ", content_text='" + content_text + '\'' +
                ", picture='" + picture + '\'' +
                ", comment_num=" + comment_num +
                ", share_num=" + share_num +
                ", like=" + like +
                ", tag='" + tag + '\'' +
                '}';
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getShare_num() {
        return share_num;
    }

    public void setShare_num(Integer share_num) {
        this.share_num = share_num;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
