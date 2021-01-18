package com.kk.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtil {
    private static List<String> fileSuffix = new ArrayList<>();

    static {
        fileSuffix.add(".jpeg");
        fileSuffix.add(".png");
        fileSuffix.add(".jpg");
        fileSuffix.add(".webp");
        fileSuffix.add(".bmp");
    }

    public static String uploadFile(MultipartFile file, String email) {
        if (Objects.equals("", email) || file.isEmpty()) {
            return null;
        }
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
            String realPath = path.replace('/', '\\').substring(1, path.length());
            //用于查看路径是否正确
            System.out.println(realPath);
            email = email + ".jpg";
            //限制文件上传的类型
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            if (fileSuffix.contains(suffix)) {
                File f = new File(realPath, email);
                //完成文件的上传
                file.transferTo(f);
                String path01 = "/upload/" + email;
                System.out.println("图片上传成功!" + path01);
                return path01;
            } else {
                System.out.println("上传失败！");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uploadsFile(MultipartFile[] files, Integer id) {
        String result = "";
        try {
            if (files.length <= 0) {
                return null;
            }
            String path = null;
            path = ResourceUtils.getURL("classpath:").getPath() + "static/news-user";
            String realPath = path.replace('/', '\\').substring(1, path.length());
            for (int i = 0; i < files.length; i++) {
                // 源文件名
                String originalFilename = files[i].getOriginalFilename();
                // 文件格式
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                if (fileSuffix.contains(suffix)) {
                    // 新文件名，避免文件名重复，造成文件替换问题
                    String fileName = id + "-" + (i + 1) + suffix;
                    result += fileName + "&";
                    // 文件存储路径
                    // 文件全路径
                    File targetFile = new File(realPath, fileName);

                    // 判断文件存储目录是否存在，不存在则新建目录
                    if (!targetFile.getParentFile().exists()) {
                        targetFile.getParentFile().mkdir();
                    }
                    // 将图片保存
                    files[i].transferTo(targetFile);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
