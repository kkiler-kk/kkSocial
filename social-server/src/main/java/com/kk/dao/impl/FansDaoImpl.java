package com.kk.dao.impl;

import static com.kk.util.LinkData.*;

import com.kk.bean.Status;
import com.kk.dao.FansDao;

public class FansDaoImpl implements FansDao {
    private FansDaoImpl(){

    }
    public static FansDao getInstance(){
        return Node.fansDao;
    }

    @Override
    public int updateLike(Status status) {
        return 0;
    }

    @Override
    public int add(Status<?> status) {
        return 0;
    }

    @Override
    public int count(Status<?> status) {
        FansDao aClass = createClass(FansDao.class);
        int count = aClass.count(status);
        closeSession();
        return count;
    }

    static class Node{
        private static FansDao fansDao = new FansDaoImpl();
    }
}
