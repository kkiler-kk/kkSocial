package com.kk.dao;

import com.kk.bean.Comments;

import java.util.List;

public interface CommentsDao {
    List<Comments> getByIdComment(Integer id, Boolean flag);

    int addComment(Comments comment);

    int updateLike(Integer id, Integer like);
}
