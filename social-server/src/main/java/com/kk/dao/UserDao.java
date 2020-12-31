package com.kk.dao;

import com.kk.bean.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String name);

    User getUserById(Integer id);

    User getUserId(Integer id);

    List<User> getUserAndFriendsById(Integer id);

    int addUser(User user);

    int addFriend(Integer user_id, Integer friend_id);

    int deleteFriend(Integer user_id, Integer friend_id);

    int deleteUserById(Integer id);

    User getUserByEmailAndPassword(String email, String password);

    int countFriends(Integer id);

    int updatePwd(String email, String password);
}
