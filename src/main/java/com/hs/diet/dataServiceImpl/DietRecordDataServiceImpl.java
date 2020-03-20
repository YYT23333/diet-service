package com.hs.diet.dataServiceImpl;

import com.hs.diet.dao.DietRecordDao;
import com.hs.diet.dataService.DietRecordDataService;
import com.hs.diet.entity.DietRecord;
import com.hs.diet.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietRecordDataServiceImpl implements DietRecordDataService {
    @Autowired
    private DietRecordDao dietRecordDao;
    @Override
    public DietRecord findById(Long id) throws NotExistException {
        Optional<DietRecord> optional=dietRecordDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("DietRecord ID",id);
        }
    }

    @Override
    public List<DietRecord> findByUserId(Long userId) {
        return dietRecordDao.findByUserId(userId);
    }
}
