package com.app;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.app.common.BaseDao;

@Repository
public class InventoryBookDao extends BaseDao {

	private Logger logger = Logger.getLogger(InventoryBookDao.class);
	
	public int getInventoryOfaBook(int bookId)throws ApplicationException {
		logger.info("Entry into method:bookId");
		return 0;
	}


}
