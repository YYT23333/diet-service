package com.hs.diet.dataService;

import com.hs.diet.entity.DietRecord;
import com.hs.diet.exception.NotExistException;

import java.util.List;

public interface DietRecordDataService {
    DietRecord findById(Long id) throws NotExistException;
    List<DietRecord> findByUserId(Long userId);
    Long add(DietRecord record);

}
