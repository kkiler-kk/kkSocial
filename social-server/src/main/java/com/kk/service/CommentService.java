package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.Comments;
import com.kk.bean.PageResult;
import com.kk.dao.CommentsDao;
import com.kk.dao.impl.CommentsDaoImpl;
import com.kk.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentsDao commentsDao;
    private CommentService(){
        commentsDao = CommentsDaoImpl.getInstance();
    }
    public PageResult getNewsByComments(Integer id, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> byIdComment = commentsDao.getByIdComment(id);
        return PageUtils.getPageResult(new PageInfo<>(byIdComment));
    }
}
