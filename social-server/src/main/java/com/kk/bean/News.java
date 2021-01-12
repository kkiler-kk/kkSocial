package com.kk.bean;


import com.alibaba.fastjson.annotation.JSONField;
import com.kk.bean.parent.Parent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel("动态类")
public class News extends Parent {
    @ApiModelProperty("发动态的人")
    private User user; //用户
    @ApiModelProperty("发布时间")
    private String create_date; //发布时间
    @ApiModelProperty("发布内容")
    private String content_text; //发布内容
    @JSONField(serialize = false)
    private String picture; //图片
    @ApiModelProperty("评论量")
    private Integer comment_num; //评论人数
    @ApiModelProperty("分享人生")
    private Integer share_num; //分享人数
    @ApiModelProperty("点赞总数")
    private Integer like; //点赞总数
    @ApiModelProperty("标签")
    private String tag;
    @ApiModelProperty("图片列表")
    private List<String> imgList;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public News(){}

    public News(Integer id, String picture, String content_text, String tag) {
        super(id);
        this.picture = picture;
        this.content_text = content_text;
        this.tag = tag;
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

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
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
