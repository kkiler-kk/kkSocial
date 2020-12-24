package com.kk.dao;

import com.kk.bean.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);

    List<User> getUserAndFriendsById(Integer id);

    void addUser(User user);

    void addFriend(Integer user_id, Integer friend_id);

    void deleteFriend(Integer user_id, Integer friend_id);
    void deleteUserById(Integer id);

    User getUserByEmailAndPassword(String email, String password);

    int countFriends(Integer id);

}
