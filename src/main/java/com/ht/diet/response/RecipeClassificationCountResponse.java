package com.ht.diet.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class RecipeClassificationCountResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<RecipeClassificationCountItem> data;

    public RecipeClassificationCountResponse(List<RecipeClassificationCountItem> counts) {
        this.code = 200;
        this.msg = "操作成功！";
        this.data = counts;
    }

    public RecipeClassificationCountResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
