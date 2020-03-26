package com.hs.diet.response;

import com.hs.diet.entity.DietRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DietRecordListResponse extends Response {
    private List<DietRecordItem> items;
    public DietRecordListResponse(List<DietRecord> records){
        this.items=new ArrayList<>();
        for (DietRecord record:records) {
            this.items.add(new DietRecordItem(record));
        }
    }
}
