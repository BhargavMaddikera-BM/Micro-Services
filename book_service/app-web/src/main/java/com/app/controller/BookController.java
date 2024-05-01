package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.ApplicationException;
import com.app.BookService;
import com.app.book.BookVo;
import com.app.common.BaseController;
import com.app.common.BaseResponse;
import com.app.common.Constants;
import com.app.helper.ConvertToVoHelper;
import com.app.request.book.BookRequest;
import com.app.request.common.JSONObject;
import com.app.response.book.BookResponse;
import com.app.response.book.ListBookResponse;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController extends BaseController {

	@Autowired
	BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@RequestMapping(value = "/v1", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> createBook(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<BookRequest> bookRequest) {
		logger.info("Entry into method:createBook");
		BaseResponse response = new BookResponse();
		try {
			logger.info("Request Payload:" + generateRequestAndResponseLogPaylod(bookRequest));
			BookVo bookVo = ConvertToVoHelper.getInstance().convertBookRequestToBookVo((bookRequest.getData()));
			bookVo = bookService.createBook(bookVo);
			((BookResponse) response).setData(bookVo);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_BOOK_CREATION,
					Constants.SUCCESS_BOOK_CREATION, Constants.BOOK_CREATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			if (e.getCause() != null) {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_CREATION,
						e.getCause().getMessage(), Constants.BOOK_CREATED_UNSUCCESSFULLY);
			} else {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_CREATION,
						e.getMessage(), Constants.BOOK_CREATED_UNSUCCESSFULLY);
			}
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/v1", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> updateBook(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<BookRequest> bookRequest) {
		logger.info("Entry into method:updateBook");
		BaseResponse response = new BookResponse();
		try {
			logger.info("Request Payload:" + generateRequestAndResponseLogPaylod(bookRequest));
			BookVo bookVo = ConvertToVoHelper.getInstance().convertBookRequestToBookVo((bookRequest.getData()));
			bookVo = bookService.updateBook(bookVo);
			((BookResponse) response).setData(bookVo);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_BOOK_UPDATION,
					Constants.SUCCESS_BOOK_UPDATION, Constants.BOOK_UPDATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_UPDATION, e.getMessage(),
					Constants.BOOK_UPDATED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/v1/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse> deleteBook(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int id) {
		logger.info("Entry into method:deleteBook");
		BaseResponse response = new BookResponse();
		try {
			BookVo bookVo = bookService.deleteBook(id);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_BOOK_DELETION,
					Constants.SUCCESS_BOOK_DELETION, Constants.BOOK_DELETED_SUCCESSFULLY);

			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_DELETION, e.getMessage(),
					Constants.BOOK_DELETED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/v1")
	public ResponseEntity<BaseResponse> getAllBooks(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		logger.info("Entry into method:getAllBooks");
		BaseResponse response = new ListBookResponse();
		try {
			List<BookVo> listAllBooks = bookService.getAllBooks();
			((ListBookResponse) response).setData(listAllBooks);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_BOOK_FETCH,
					Constants.SUCCESS_BOOK_FETCH, Constants.BOOK_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_FETCH, e.getMessage(),
					Constants.BOOK_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/v1/{id}")
	public ResponseEntity<BaseResponse> getBookDetails(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int id) {
		logger.info("Entry into method:getBookDetails");
		BaseResponse response = new BookResponse();
		try {
			BookVo data = bookService.getBookDetails(id);
			((BookResponse) response).setData(data);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_BOOK_FETCH,
					Constants.SUCCESS_BOOK_FETCH, Constants.BOOK_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_BOOK_FETCH, e.getMessage(),
					Constants.BOOK_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
