package com.ht.diet.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UploadResponse extends Response {
    @ApiModelProperty("返回数据")
    private String data;
    public UploadResponse(String url){
        this.code = "200";
        this.msg = "操作成功！";
        this.data=url;
    }
}
