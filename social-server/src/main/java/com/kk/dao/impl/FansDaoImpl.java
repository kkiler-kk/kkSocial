package com.kk.dao.impl;

import static com.kk.util.LinkData.*;
import com.kk.dao.FansDao;

public class FansDaoImpl implements FansDao {
    private FansDaoImpl(){

    }
    public static FansDao getInstance(){
        return Node.fansDao;
    }
    static class Node{
        private static FansDao fansDao = new FansDaoImpl();
    }
    @Override
    public Integer countUser(Integer id) {
        FansDao aClass = createClass(FansDao.class);
        Integer integer = aClass.countUser(id);
        closeSession();
        return integer;
    }

    @Override
    public Integer countFans(Integer id) {
        FansDao aClass = createClass(FansDao.class);
        Integer integer = aClass.countFans(id);
        closeSession();
        return integer;
    }
}
