package org.kk.bean;

import org.kk.bean.parent.Parent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "用户类")
public class User extends Parent implements Serializable {
    @ApiModelProperty(value = "邮箱")
    private String email;//邮箱
    @ApiModelProperty(value = "密码")
    private String password;//密码
    @ApiModelProperty("姓名")
    private String name;//姓名
    @ApiModelProperty("性别: 0 女 1 男")
    private Integer gender;//性别
    @ApiModelProperty("个性签名")
    private String personal_signature;
    @ApiModelProperty("头像路径")
    private String url;  //头像路径
    @ApiModelProperty("用户信息")
    private UserInfo userInfo;
    @ApiModelProperty("用户创建时间")
    private String create_date;
    public User(){

    }
    public User( String email, String password, String name, Integer gender,String url, String date) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.url = url;
        this.create_date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", create_date=" + create_date +
                ", id=" + id +
                '}';
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPersonal_signature() {
        return personal_signature;
    }

    public void setPersonal_signature(String personal_signature) {
        this.personal_signature = personal_signature;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
