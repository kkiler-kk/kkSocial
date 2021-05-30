package org.kk.dao;

import org.kk.bean.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String name);

    User getUserById(Integer id);

    User getUserId(Integer id);

    User getByData(Integer id);

    List<User> getUserAndFriendsById(Integer id);
    Integer isAttention(Integer id, String name);
    int addUser(User user);

    int addFriend(Integer user_id, Integer friend_id);

    int deleteFriend(Integer user_id, Integer friend_id);

    int deleteUserById(Integer id);

    Integer getUserEAndP(String email, String password);

    int countFriends(Integer id);
    Integer existName(String name);
    int updatePwd(String email, String password);
}
