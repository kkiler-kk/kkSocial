package com.kk.dao;

import com.kk.bean.User;
import com.kk.bean.UserInfo;

import java.util.List;

/**
 * @author kk
 * @Date 2021/1/22
 */
public interface UserInfoDao {
    UserInfo getFUN(Integer id);
    UserInfo getUserHome(Integer id);
    List<User> getFriends(Integer id);
    UserInfo getFriendsCount(Integer id);
}
