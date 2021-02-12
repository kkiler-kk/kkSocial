package org.kk.dao;

import org.kk.bean.Comments;

import java.util.List;

public interface CommentsDao extends GiveParent{
    List<Comments> getByIdComment(Integer id, Boolean flag);
}
