package com.kk.service;

import com.kk.bean.Comments;
import com.kk.dao.CommentsDao;
import com.kk.dao.impl.CommentsDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentsDao commentsDao;
    private CommentService(){
        commentsDao = CommentsDaoImpl.getInstance();
    }
    public List<Comments> getNewsByComments(Integer id){
        return commentsDao.getByIdComment(id);
    }
}
