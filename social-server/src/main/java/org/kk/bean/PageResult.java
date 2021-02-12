package org.kk.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "分页返回对象")
public class PageResult {
    /**
     * 当前页码
     */
    @ApiModelProperty("当前页码")
    private int pageNum;
    /**
     * 每页数量
     */
    @ApiModelProperty("每页数量")
    private int pageSize;
    /**
     * 记录总数
     */
    @ApiModelProperty("记录总数")
    private long totalSize;
    /**
     * 页码总数
     */
    @ApiModelProperty("页码总数")
    private int totalPages;
    /**
     * 数据模型
     */
    @ApiModelProperty("总数据")
    private List<?> content;
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<?> getContent() {
        return content;
    }
    public void setContent(List<?> content) {
        this.content = content;
    }
}
