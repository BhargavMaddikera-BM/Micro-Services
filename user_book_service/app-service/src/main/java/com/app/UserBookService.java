package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.BaseService;
import com.app.userbook.UserBookVo;


@Service
public class UserBookService extends BaseService{

	@Autowired
	UserBookDao userBookDao;	

	private  Logger logger = Logger.getLogger(UserBookService.class);



	public void bookNewRequest(UserBookVo userBookVo)throws ApplicationException {
		logger.info("Entry into method:bookNewRequest");
		// logic for At a time user can only borrow 1 book at a time, A user cannot borrow more than 2 books,A user can borrow a book for a max of 7 days.
		userBookDao.bookNewRequest(userBookVo);
	}

	public void updateExistingRequest(UserBookVo userBookVo)throws ApplicationException {	
		logger.info("Entry into method:updateExistingRequest");
		// logic for A user can borrow a book for a max of 7 days.
		userBookDao.updateExistingRequest(userBookVo);
	}

	public void closeExistingRequest(int userId, int bookId)throws ApplicationException {	
		logger.info("Entry into method:closeExistingRequest");
		userBookDao.closeExistingRequest(userId, bookId);
	}
	
	public List<UserBookVo>getAllBooksOfUser(int userId)throws ApplicationException{
		logger.info("Entry into method:getAllBooksOfUser");
		return userBookDao.getAllBooksOfUser(userId);
	}
	

}
