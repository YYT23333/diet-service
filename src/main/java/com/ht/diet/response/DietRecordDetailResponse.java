package com.ht.diet.response;

import com.ht.diet.entity.DietRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class DietRecordDetailResponse extends Response {
    @ApiModelProperty("返回数据")
    private DietRecordDetailItem data;
    public DietRecordDetailResponse(DietRecord record){
        this.data=new DietRecordDetailItem(record);
        this.code = 200;
        this.msg = "操作成功！";
    }
    public DietRecordDetailResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
