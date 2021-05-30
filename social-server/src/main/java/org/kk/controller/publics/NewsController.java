package org.kk.controller.publics;

import org.kk.bean.PageRequest;
import org.kk.bean.PageResult;
import org.kk.bean.ResponseResult;
import org.kk.service.NewsService;
import org.kk.util.*;
import io.swagger.annotations.*;
import org.kk.util.ErrorCode;
import org.kk.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "动态Controller",tags = "动态接口")
@RestController(value = "NewsPublic")
@RequestMapping(value = "/public")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ApiOperation(value = "返回最热动态")
    @PostMapping(value = "/get-top")
    public ResponseResult<PageResult> getTop(@ApiParam("分页对象")@RequestBody PageRequest pageRequest){
        PageResult selectRandom = newsService.getSelectRandom(pageRequest);
        return new ResponseResult<>(selectRandom);
    }
    @ApiOperation(value = "根据tag查找动态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag", value = "查找的tag", dataType = "String"),
            @ApiImplicitParam(name = "pageRequest", value = "分页对象")
    })
    @PostMapping(value = "/tag/{tag}")
    public ResponseResult<PageResult> getTag(@PathVariable String tag,@RequestBody PageRequest pageRequest){
        if(StrUtil.isEmpty(tag)) return new ResponseResult<>(ErrorCode.ILLEGAL_NULL);
        PageResult newsByTag = newsService.getNewsByTag(tag, pageRequest);
        return new ResponseResult<>(newsByTag);
    }
    @ApiOperation("返回最热标签")
    @GetMapping(value = "/get-tag")
    public ResponseResult<List<String>> getTopTag(){
        List<String> topTag = newsService.getTopTag();
        return new ResponseResult<>(topTag);
    }
    @ApiOperation("返回用户搜索最热top")
    @GetMapping(value = "/get-search")
    public ResponseResult<String> getSearch(){
        String topSearcher = newsService.getSearch();
        return new ResponseResult<>(topSearcher);
    }
    @ApiOperation("返回热搜")
    @GetMapping(value = "/top-search")
    public ResponseResult<List<String>> getTopSearch(){
        List<String> topSearch = newsService.getTopSearch();
        return new ResponseResult<>(topSearch);
    }
}
