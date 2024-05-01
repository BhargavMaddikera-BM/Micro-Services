package com.app;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.BaseService;


@Service
public class UserBookService extends BaseService{

	@Autowired
	InventoryBookDao inventoryBookDao;	

	private  Logger logger = Logger.getLogger(InventoryBookDao.class);


	public int getInventoryOfaBook(int bookId)throws ApplicationException {
		logger.info("Entry into method:bookId");
		return inventoryBookDao.getInventoryOfaBook(bookId);
	}
	

}
