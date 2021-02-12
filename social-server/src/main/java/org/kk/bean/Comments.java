package org.kk.bean;

import org.kk.bean.parent.Dynamic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论类
 */
@ApiModel("评论类")
public class Comments extends Dynamic {
    @ApiModelProperty("动态Id")
    private Integer new_id; //动态表ID
    @ApiModelProperty("父级评论Id")
    private Integer write_id; //父级评论Id

    public Comments(){}
    public Comments(Integer id, Integer new_id, String content) {
        super(id,content);
        this.new_id = new_id;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "new_id=" + new_id +
                ", write_id=" + write_id +
                '}';
    }

    public Integer getNew_id() {
        return new_id;
    }

    public void setNew_id(Integer new_id) {
        this.new_id = new_id;
    }

    public Integer getWrite_id() {
        return write_id;
    }

    public void setWrite_id(Integer write_id) {
        this.write_id = write_id;
    }
}
