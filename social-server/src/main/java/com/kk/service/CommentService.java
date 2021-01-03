package com.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.bean.Comments;
import com.kk.bean.PageRequest;
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
    public PageResult getNewsByComments(Integer id, PageRequest pageRequest, boolean flag){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> byIdComment = commentsDao.getByIdComment(id, flag);
        return PageUtils.getPageResult(new PageInfo<>(byIdComment));
    }
}
