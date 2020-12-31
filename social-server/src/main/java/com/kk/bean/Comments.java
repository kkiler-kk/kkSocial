package com.kk.bean;

import com.kk.bean.parent.Parent;

/**
 * 评论类
 */
public class Comments extends Parent {
    private News news; //动态表ID
    private String content; //评论内容
    private User user; //用户id;
    private String create_date; //创建时间
    private int like;



    public Comments(){}
    public Comments(Integer id, News new_id, String content, User user, String create_date) {
        super(id);
        this.news = new_id;
        this.content = content;
        this.user = user;
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "news=" + news +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", create_date='" + create_date + '\'' +
                ", like=" + like +
                '}';
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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
