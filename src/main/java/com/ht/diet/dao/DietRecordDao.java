package com.ht.diet.dao;

import com.ht.diet.entity.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DietRecordDao extends JpaRepository<DietRecord,String> {
    Optional<DietRecord> findById(long id);
    List<DietRecord> findByUserId(long userId);
}
