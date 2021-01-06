package com.kk.bean;

import com.kk.bean.parent.Parent;

/**
 * 群号类
 */
public class GroupChat extends Parent {
    private String name; //群昵称
    private Integer name_id; //群号
    private Integer count; //群总数
    private String create_date; //创建时间
    private Integer user_id; //创建人
    private String url; //群头像
}
