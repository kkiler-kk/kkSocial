package com.kk.bean;


public class News {
    private Integer new_id;  //主键

    private User user; //用户
    private String create_date; //发布时间
    private String content_text; //发布内容
    private String picture; //图片
    private Integer comment_num; //评论人数
    private Integer share_num; //分享人数
    private Integer type;  //动态类型
    private Integer like; //点赞总数

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public News(){}

    public News(Integer new_id, User user, String create_date, String content_text, String picture, Integer comment_num, Integer share_num, Integer type, Integer like) {
        this.new_id = new_id;
        this.user = user;
        this.create_date = create_date;
        this.content_text = content_text;
        this.picture = picture;
        this.comment_num = comment_num;
        this.share_num = share_num;
        this.type = type;
        this.like = like;
    }

    @Override
    public String toString() {
        return "News{" +
                "new_id=" + new_id +
                ", user=" + user +
                ", create_data='" + create_date + '\'' +
                ", content_text='" + content_text + '\'' +
                ", picture='" + picture + '\'' +
                ", comment_num=" + comment_num +
                ", share_num=" + share_num +
                ", type=" + type +
                ", like=" + like +
                '}';
    }

    public Integer getNew_id() {
        return new_id;
    }

    public void setNew_id(Integer new_id) {
        this.new_id = new_id;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user;
    }

    public String getCreate_data() {
        return create_date;
    }

    public void setCreate_data(String create_date) {
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

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getShare_num() {
        return share_num;
    }

    public void setShare_num(int share_num) {
        this.share_num = share_num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

}
