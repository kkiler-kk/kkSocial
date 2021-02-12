package org.kk.controller.publics;

import org.kk.bean.*;
import org.kk.bean.PageRequest;
import org.kk.bean.PageResult;
import org.kk.bean.ResponseResult;
import org.kk.service.CommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "评论Controller", tags = "评论接口")
@RestController(value = "CommentsPublic")
@RequestMapping(value = "/public")
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @ApiOperation("根据动态id传输评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态ID", dataType = "Integer"),
            @ApiImplicitParam(name = "pageRequest", value = "分页对象", dataType = "PageRequest"),
            @ApiImplicitParam(name = "flag", value = "true按热度false按时间", dataType = "boolean")
    })
    @PostMapping(value = "/news-id/{id}/{flag}")
    public ResponseResult<PageResult> getNewsById(@PathVariable Integer id, @PathVariable boolean flag, @RequestBody PageRequest pageRequest){
        PageResult newsByComments = commentService.getNewsByComments(id, pageRequest, flag);
        return new ResponseResult<>(newsByComments);
    }
}
