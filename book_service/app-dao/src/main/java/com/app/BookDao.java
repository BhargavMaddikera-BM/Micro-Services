package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.app.book.BookVo;
import com.app.common.BaseDao;

@Repository
public class BookDao extends BaseDao {

	private Logger logger = Logger.getLogger(BookDao.class);
	
	public BookVo createBook(BookVo bookVo)throws ApplicationException {
		logger.info("Entry into method:createBook");
		return bookVo;
	}

	public BookVo updateBook(BookVo bookVo)throws ApplicationException {	
		logger.info("Entry into method:updateBook");
		return bookVo;
	}

	public BookVo deleteBook(int id)throws ApplicationException {	
		logger.info("Entry into method:deleteBook");
		return null;
	}
	
	public List<BookVo>getAllBooks()throws ApplicationException{
		logger.info("Entry into method:getAllBooks");
		return null;
	}
	

	public BookVo getBookDetails(int id)throws ApplicationException {	
		logger.info("Entry into method:getBookDetails");
		return null;
	}


}
