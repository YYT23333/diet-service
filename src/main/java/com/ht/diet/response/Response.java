package com.ht.diet.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Response implements Serializable {
    @ApiModelProperty("code")
    public String code;
    @ApiModelProperty("code详情")
    public String msg;
    public Response(){
        this.code = "200";
        this.msg = "操作成功！";
    }
}
