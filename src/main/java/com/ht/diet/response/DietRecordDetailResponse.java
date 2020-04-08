package com.ht.diet.response;

import com.ht.diet.entity.DietRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DietRecordDetailResponse extends Response {
    @ApiModelProperty("返回数据")
    private DietRecordItem data;
    public DietRecordDetailResponse(DietRecord record){
        this.data=new DietRecordItem(record);
        this.code = "200";
        this.msg = "操作成功！";
    }
}
