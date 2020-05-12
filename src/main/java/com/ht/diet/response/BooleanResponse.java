package com.ht.diet.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BooleanResponse extends  Response {
    @ApiModelProperty("返回数据")
    private boolean data;
    public BooleanResponse(boolean result){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=result;
    }
    public BooleanResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
