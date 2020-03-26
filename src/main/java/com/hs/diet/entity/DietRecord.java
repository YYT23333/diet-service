package com.hs.diet.entity;

import com.hs.diet.enums.DietRecordType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    @Column
    private LocalDateTime time;

    @Column
    private DietRecordType type;

    @Column
    private double calories;

    @ElementCollection
    private List<DietItem> dietItems;
}
