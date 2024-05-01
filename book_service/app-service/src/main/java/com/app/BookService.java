package com.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.book.BookVo;
import com.app.common.BaseService;


@Service
public class BookService extends BaseService{

	@Autowired
	BookDao bookDao;	

	private  Logger logger = Logger.getLogger(BookService.class);



	public BookVo createBook(BookVo bookVo)throws ApplicationException {
		logger.info("Entry into method:createBook");
		return bookDao.createBook(bookVo);
	}

	public BookVo updateBook(BookVo bookVo)throws ApplicationException {	
		logger.info("Entry into method:updateBook");
		return bookDao.updateBook(bookVo);
	}

	public BookVo deleteBook(int id)throws ApplicationException {	
		logger.info("Entry into method:deleteBook");
		return bookDao.deleteBook(id);
	}
	
	public List<BookVo>getAllBooks()throws ApplicationException{
		logger.info("Entry into method:getAllBooks");
		return bookDao.getAllBooks();
	}
	

	public BookVo getBookDetails(int id)throws ApplicationException {	
		logger.info("Entry into method:getBookDetails");
		return bookDao.getBookDetails(id);
	}


	

}
