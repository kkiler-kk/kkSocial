package org.kk.bean;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import org.kk.util.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.kk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

@ApiModel(value = "返回数据对象")
public class ResponseResult<Item> {
    @ApiModelProperty("是否成功")
    private boolean status;
    @ApiModelProperty("返回的数据")
    private Item data;
    @ApiModelProperty("错误信息code")
    private Integer code;
    @ApiModelProperty("错误信息")
    private String message;
    @ApiModelProperty("日期")
    private String date;
    public ResponseResult(){}

    public ResponseResult(Item data){
        this.status = true;
        this.data = data;
        this.code = ErrorCode.SUCCESS;
        this.message = "OK";
        this.date = DateUtil.now();
    }
    public ResponseResult(Integer errorCode){
        this.status = errorCode.equals(ErrorCode.SUCCESS);
        this.code = errorCode;
        this.message = ErrorCode.ERROR_MAP.get(errorCode);
        this.date = DateUtil.now();
    }
    public ResponseResult(Integer errorCode, String message){
        this.code = errorCode;
        this.message = message;
        this.status = false;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
