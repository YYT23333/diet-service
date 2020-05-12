package com.ht.diet.response;

import com.ht.diet.entity.DietRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class DietRecordListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<DietRecordListItem> data;
    public DietRecordListResponse(List<DietRecordListItem> records){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=new ArrayList<>();
        this.data=records;
    }
    public DietRecordListResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
