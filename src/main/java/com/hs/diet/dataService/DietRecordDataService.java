package com.hs.diet.dataService;

import com.hs.diet.entity.DietRecord;

import java.util.List;

public interface DietRecordDataService {
    DietRecord findById(Long id);
    List<DietRecord> findByUserId(Long userId);

}
