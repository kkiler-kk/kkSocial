package com.kk.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.kk.bean.*;
import com.kk.service.CommentService;
import com.kk.util.ErrorCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "评论Controller", tags = "评论接口")
@RestController
@RequestMapping(value = "comment")
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @ApiOperation("根据动态id传输评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态ID", dataType = "Integer"),
            @ApiImplicitParam(name = "pageRequest", value = "分页对象", dataType = "PageRequest"),
            @ApiImplicitParam(name = "flag", value = "true按热度false按时间", dataType = "boolean")
    })
    @RequestMapping(value = "/news-id/{id}/{flag}", method = RequestMethod.POST)
    public ResponseResult<PageResult> getNewsById(@PathVariable Integer id, @RequestBody PageRequest pageRequest,@PathVariable boolean flag){
        PageResult newsByComments = commentService.getNewsByComments(id, pageRequest, flag);
        return new ResponseResult<>(newsByComments);
    }
    @ApiOperation("发布评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(name = "new_id", value = "动态id", dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "发布内容", dataType = "String")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<String> addComment(HttpServletRequest request, Comments comments){
        Object userId = request.getAttribute("userId");
        int i = Integer.parseInt(String.valueOf(userId));
        comments.setId(i);
        Integer integer = commentService.addComments(comments);
        return integer > 0 ? new ResponseResult<>("OK") : new ResponseResult<>(ErrorCode.INSERT_FAIL);
    }
}
