package com.hs.diet.dao;

import com.hs.diet.entity.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DietRecordDao extends JpaRepository<DietRecord,String> {
    Optional<DietRecord> findById(Long id);
    List<DietRecord> findByUserId(Long userId);
}
