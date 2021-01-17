package com.kk.controller;

import com.kk.util.FileUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author KK
 * @Date 2020-11-10 22:19
 */
@Api(value = "上传Controller",tags = "文件接口")
@RestController
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("email") String email, HttpServletResponse response) throws IOException {
        String upload = FileUtil.uploadFile(file, email);
        response.sendRedirect("/");
        return upload;
    }
    @PostMapping("uploadFile")
    public String uploadFile(@RequestParam("files") MultipartFile[] files) {
            return "";
    }
}