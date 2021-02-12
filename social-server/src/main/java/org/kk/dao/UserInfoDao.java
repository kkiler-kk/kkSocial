package org.kk.dao;

import org.kk.bean.User;
import org.kk.bean.UserInfo;

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
