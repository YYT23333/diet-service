package com.hs.diet.dao;

import com.hs.diet.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, String> {
}
