package org.kk.bean;

import org.kk.bean.parent.Parent;

public class Like extends Parent {
    private Integer user_id;
    private News news;
    public Like(){}
    @Override
    public String toString() {
        return "Like{" +
                "user_id=" + user_id +
                ", news=" + news +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
