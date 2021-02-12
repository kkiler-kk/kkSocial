package org.kk.bean.parent;

import org.kk.bean.User;

public class Dynamic {
    protected Integer id; //id
    protected String content_text; //评论内容
    protected User user; //用户id;
    protected String create_date; //创建时间
    protected int like;
    public Dynamic(){}

    public Dynamic(Integer id, String content_text) {
        this.id = id;
        this.content_text = content_text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
