package com.ht.diet.response;

import com.ht.diet.entity.Recipe;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RecipeDetailResponse extends Response {
    @ApiModelProperty("返回数据")
    private RecipeDetailItem data;
    public RecipeDetailResponse(Recipe recipe){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=new RecipeDetailItem(recipe);
    }
    public RecipeDetailResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
