package org.kk.util;

import com.github.pagehelper.PageInfo;
import org.kk.bean.PageResult;

public final class PageUtils {
    private PageUtils(){}
    /**
     * 将分页信息封装到统一的接口
     */
    public static final PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
