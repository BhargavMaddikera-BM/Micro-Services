package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.app.common.BaseDao;
import com.app.userbook.UserBookVo;

@Repository
public class UserBookDao extends BaseDao {

	private Logger logger = Logger.getLogger(UserBookDao.class);
	
	public void bookNewRequest(UserBookVo userBookVo)throws ApplicationException {
		logger.info("Entry into method:bookNewRequest");
	}

	public void updateExistingRequest(UserBookVo userBookVo)throws ApplicationException {	
		logger.info("Entry into method:updateExistingRequest");
	}

	public void closeExistingRequest(int userId, int bookId)throws ApplicationException {	
		logger.info("Entry into method:closeExistingRequest");
	}
	
	public List<UserBookVo>getAllBooksOfUser(int userId)throws ApplicationException{
		logger.info("Entry into method:getAllBooksOfUser");
		return null;
	}
	
}
