package com.kk.controller.privates;

import com.kk.bean.News;
import com.kk.bean.PageRequest;
import com.kk.bean.PageResult;
import com.kk.bean.ResponseResult;
import com.kk.service.NewsService;
import com.kk.util.CodeUtil;
import com.kk.util.ErrorCode;
import com.kk.util.FileUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Api(value = "用户private Controller", tags = "动态接口")
@RestController(value = "NewsPrivate")
@RequestMapping(value = "/private")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "新增动态")
    @PostMapping(value = "add-news", headers = "content-type=multipart/form-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news", value = "只需要传入Id(用户id)content_text(发布内容)tag(标签 可选)"),
            @ApiImplicitParam(name = "files", value = "上传的图片")
    })
    public ResponseResult<String> addNews(HttpServletRequest request, @RequestBody News news, @RequestBody MultipartFile[] files){
        String s = FileUtil.uploadsFile(files, Integer.parseInt(CodeUtil.generateVerCode()));
        Integer id = (Integer)request.getAttribute("id");
        news.setId(id);
        news.setPicture(s);
        Integer add = newsService.add(news);
        return add > 0 ? new ResponseResult<>("OK") : new ResponseResult<>(ErrorCode.INSERT_FAIL);
    }

    @ApiOperation(value = "返回好友动态")
    @PostMapping(value = "get-news")
    public ResponseResult<PageResult> getList(HttpServletRequest request, @ApiParam("分页对象") PageRequest pageRequest){
        Object userId = request.getAttribute("id");
        int i = Integer.parseInt(String.valueOf(userId));
        PageResult friends = newsService.getFriends(i, pageRequest);
        return new ResponseResult<>(friends);
    }
}
