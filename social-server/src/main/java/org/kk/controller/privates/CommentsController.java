package org.kk.controller.privates;

import org.kk.bean.Comments;
import org.kk.bean.ResponseResult;
import org.kk.service.CommentService;
import org.kk.util.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "评论Controller", tags = "评论接口")
@RestController(value = "CommentPrivate")
@RequestMapping(value = "private")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("发布评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(name = "new_id", value = "动态id", dataType = "Integer"),
            @ApiImplicitParam(name = "content", value = "发布内容", dataType = "String")
    })
    @RequestMapping(value = "/add-comm", method = RequestMethod.POST)
    public ResponseResult<String> addComment(HttpServletRequest request, @RequestBody Comments comments){
        Object userId = request.getAttribute("id");
        int i = Integer.parseInt(String.valueOf(userId));
        comments.setId(i);
        Integer integer = commentService.addComments(comments);
        return integer > 0 ? new ResponseResult<>("OK") : new ResponseResult<>(ErrorCode.INSERT_FAIL);
    }
}
