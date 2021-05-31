package org.kk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kk.bean.Comments;
import org.kk.bean.PageRequest;
import org.kk.bean.PageResult;
import org.kk.bean.Status;
import org.kk.dao.CommentsDao;
import org.kk.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentService {
    @Autowired
    private CommentsDao commentsDao;

    public PageResult getNewsByComments(Integer id, PageRequest pageRequest, boolean flag){
        int pageNum = pageRequest.getPageNum(), pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> byIdComment = commentsDao.getByIdComment(id, flag);
        return PageUtils.getPageResult(new PageInfo<>(byIdComment));
    }
    public Integer addComments(Comments comment){
        return commentsDao.add(new Status<>(comment));
    }
}
