package com.kk.bean;

/**
 * 评论类
 */
public class Comments {
    private Integer comment_id;
    private News news; //动态表ID
    private String content; //评论内容
    private User user; //用户id;
    private String create_date; //创建时间
    public Comments(){}
    public Comments(Integer id, News new_id, String content, User user, String create_data) {
        this.comment_id = id;
        this.news = new_id;
        this.content = content;
        this.user = user;
        this.create_date = create_data;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment_id=" + comment_id +
                ", new=" + news +
                ", content='" + content + '\'' +
                ", user='" + user + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }

    public Integer getId() {
        return comment_id;
    }

    public void setId(Integer id) {
        this.comment_id = id;
    }

    public News getNew_id() {
        return news;
    }

    public void setNew_id(News new_id) {
        this.news = new_id;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
    }

    public String getCreate_data() {
        return create_date;
    }

    public void setCreate_data(String create_data) {
        this.create_date = create_data;
    }
}
