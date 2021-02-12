package org.kk.dao;

import org.kk.bean.Status;

public interface GiveParent {
    int updateLike(Status status);

    int add(Status<?> status);

    Integer count(Status<?> status);
}