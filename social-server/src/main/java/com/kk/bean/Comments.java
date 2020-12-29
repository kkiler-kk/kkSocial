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

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
