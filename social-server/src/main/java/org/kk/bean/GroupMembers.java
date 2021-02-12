package org.kk.bean;

import org.kk.bean.parent.Parent;

/**
 * 群成员类
 */
public class GroupMembers extends Parent {
    private Integer group_id; //群号 属于哪个群的
    private Integer user_id; //群成员
    private String create_date; //创建时间
}
