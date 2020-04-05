package com.hs.diet.response;

import com.hs.diet.entity.DietRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
