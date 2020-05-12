package com.ht.diet.dataService;

import com.ht.diet.entity.DietRecord;
import com.ht.diet.exception.NotExistException;

import java.time.LocalDateTime;
import java.util.List;

public interface DietRecordDataService {
    DietRecord findById(long id) throws NotExistException;
    List<DietRecord> findByUserIdAndTime(long userId, LocalDateTime time);
    Long add(DietRecord record);

}
