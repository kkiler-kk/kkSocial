package com.kk.bean;

import com.kk.util.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回数据对象")
public class ResponseResult<Item> {
    @ApiModelProperty("是否成功")
    private boolean status;
    @ApiModelProperty("返回的数据")
    private Item data;
    @ApiModelProperty("错误信息code")
    private Integer errorCode;
    @ApiModelProperty("错误信息")
    private String message;
    public ResponseResult(){}

    public ResponseResult(Item data){
        this.status = true;
        this.data = data;
        this.errorCode = ErrorCode.SUCCESS;
        this.message = "OK";
    }
    public ResponseResult(Integer errorCode){
        this.status = errorCode.equals(ErrorCode.SUCCESS);
        this.errorCode = errorCode;
        this.message = ErrorCode.ERROR_MAP.get(errorCode);
    }
    public ResponseResult(Integer errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
        this.status = false;
    }
    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", data=" + data +
                ", errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Item getData() {
        return data;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
