package com.kk.bean;


import com.alibaba.fastjson.annotation.JSONField;
import com.kk.bean.parent.Dynamic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel("动态类")
public class News extends Dynamic {
    @JSONField(serialize = false)
    private String picture; //图片
    @ApiModelProperty("评论量")
    private Integer comment_num; //评论人数
    @ApiModelProperty("分享人生")
    private Integer share_num; //分享人数
    @ApiModelProperty("标签")
    private String tag;
    @ApiModelProperty("图片列表")
    private List<String> imgList;

    public News(){}

    public News(Integer id, String picture, String content_text, String tag) {
        super(id,content_text);
        this.picture = picture;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "News{" +
                "picture='" + picture + '\'' +
                ", comment_num=" + comment_num +
                ", share_num=" + share_num +
                ", tag='" + tag + '\'' +
                ", imgList=" + imgList +
                '}';
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
