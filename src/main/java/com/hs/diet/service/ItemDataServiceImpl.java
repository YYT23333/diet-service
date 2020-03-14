package com.hs.diet.service;

import com.hs.diet.dao.ItemDao;
import com.hs.diet.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDataServiceImpl implements ItemDataService{

	@Autowired
	private ItemDao itemDao;

	public Item add(Item user) {
		return itemDao.save(user);
	}


}
