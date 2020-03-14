package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.DietRecordDao;
import com.hs.diet.dataService.DietRecordDataService;
import com.hs.diet.entity.DietRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietRecordDataServiceImpl implements DietRecordDataService {
    @Autowired
    private DietRecordDao dietRecordDao;
    @Override
    public DietRecord findById(Long id) {
        return dietRecordDao.findById(id);
    }

    @Override
    public List<DietRecord> findByUserId(Long userId) {
        return dietRecordDao.findByUserId(userId);
    }
}
