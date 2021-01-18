package com.kk.dao;

import com.kk.bean.Status;

public interface GiveParent {
    int updateLike(Status status);

    int add(Status<?> status);

    int count(Status<?> status);
}