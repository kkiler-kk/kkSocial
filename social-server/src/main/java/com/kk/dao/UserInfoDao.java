package com.kk.dao;

import com.kk.bean.UserInfo;

/**
 * @author kk
 * @Date 2021/1/22
 */
public interface UserInfoDao {
    UserInfo getFUN(Integer id);
    UserInfo getUserHome(Integer id);
}
