package com.kk.bean;

/**
 * 评论类
 */
public class Comments {
    private Integer id;
    private News news; //动态表ID
    private String content; //评论内容
    private User user; //用户id;
    private String create_data; //创建时间

    public Comments(Integer id, News new_id, String content, User user, String create_data) {
        this.id = id;
        this.news = new_id;
        this.content = content;
        this.user = user;
        this.create_data = create_data;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", new=" + news +
                ", content='" + content + '\'' +
                ", user='" + user + '\'' +
                ", create_data='" + create_data + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return create_data;
    }

    public void setCreate_data(String create_data) {
        this.create_data = create_data;
    }
}
