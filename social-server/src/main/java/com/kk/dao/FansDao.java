package com.kk.dao;

public interface FansDao {
    //统计我关注了多少博主
    Integer countUser(Integer id);
    //统计我有多少粉丝
    Integer countFans(Integer id);
}
