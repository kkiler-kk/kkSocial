package com.kk.dao;

import com.kk.bean.Comments;

import java.util.List;

public interface CommentsDao {
    List<Comments> getByIdComment(Integer id);
}
