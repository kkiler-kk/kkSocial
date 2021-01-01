package com.kk.controller;

import com.kk.bean.Comments;
import com.kk.bean.ResponseResult;
import com.kk.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("评论Controller")
@RestController
@RequestMapping(value = "comment")
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @ApiOperation("根据动态id传输评论")
    @RequestMapping(value = "/news-id/{id}", method = RequestMethod.GET)
    public ResponseResult<List<Comments>> getNewsById(@ApiParam("动态ID") @PathVariable Integer id){
        List<Comments> newsByComments = commentService.getNewsByComments(id);
        return new ResponseResult<>(newsByComments);
    }
}
