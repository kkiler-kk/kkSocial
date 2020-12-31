package com.kk.bean;

import com.kk.util.ErrorCode;

public class ResponseResult<Item> {
    private boolean status;
    private Item data;
    private Integer errorCode;
    private String message;
    public ResponseResult(){}

    public ResponseResult(Item data){
        this.status = true;
        this.data = data;
        this.errorCode = ErrorCode.SUCCESS;
        this.message = "OK";
    }
    public ResponseResult(Integer errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
        this.status = false;
    }
    @Override
    public String toString() {
        return "Dto{" +
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
