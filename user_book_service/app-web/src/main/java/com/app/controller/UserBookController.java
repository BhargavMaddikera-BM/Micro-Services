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
import com.app.UserBookService;
import com.app.common.BaseController;
import com.app.common.BaseResponse;
import com.app.common.Constants;
import com.app.helper.ConvertToVoHelper;
import com.app.request.common.JSONObject;
import com.app.request.userbook.UserBookRequest;
import com.app.response.book.BookResponse;
import com.app.response.book.ListBookResponse;
import com.app.userbook.UserBookVo;

@RestController
@CrossOrigin
@RequestMapping("user/book")
public class UserBookController extends BaseController {

	@Autowired
	UserBookService userBookService;

	private static final Logger logger = LoggerFactory.getLogger(UserBookController.class);

	@RequestMapping(value = "/v1", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> bookNewRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<UserBookRequest> userBookRequest) {
		logger.info("Entry into method:bookNewRequest");
		BaseResponse response = new BookResponse();
		try {
			UserBookVo userBookVo = ConvertToVoHelper.getInstance().convertUserBookRequestToBookVo((userBookRequest.getData()));
			userBookService.bookNewRequest(userBookVo);
			((BookResponse) response).setData(null);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_BOOK_CREATION,
					Constants.SUCCESS_USER_BOOK_CREATION, Constants.USER_BOOK_CREATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			if (e.getCause() != null) {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_BOOK_CREATION,
						e.getCause().getMessage(), Constants.USER_BOOK_CREATED_UNSUCCESSFULLY);
			} else {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_BOOK_CREATION,
						e.getMessage(), Constants.USER_BOOK_CREATED_UNSUCCESSFULLY);
			}
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/v1", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> updateExistingRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<UserBookRequest> userBookRequest) {
		logger.info("Entry into method:updateExistingRequest");
		BaseResponse response = new BookResponse();
		try {
			UserBookVo userBookVo = ConvertToVoHelper.getInstance().convertUserBookRequestToBookVo((userBookRequest.getData()));
			userBookService.updateExistingRequest(userBookVo);
			((BookResponse) response).setData(null);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_BOOK_UPDATION,
					Constants.SUCCESS_USER_BOOK_UPDATION, Constants.USER_BOOK_UPDATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_BOOK_UPDATION, e.getMessage(),
					Constants.USER_BOOK_UPDATED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/v1/{userId}/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse> closeExistingRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int userId,@PathVariable int bookId) {
		logger.info("Entry into method:closeExistingRequest");
		BaseResponse response = new BookResponse();
		try {
			userBookService.closeExistingRequest(userId,bookId);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_BOOK_CLOSED,
					Constants.SUCCESS_USER_BOOK_CLOSED, Constants.USER_BOOK_CLOSED_SUCCESSFULLY);

			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_BOOK_CLOSED, e.getMessage(),
					Constants.USER_BOOK_CLOSED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/v1/{userid}")
	public ResponseEntity<BaseResponse> getAllBooksOfUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int userid) {
		logger.info("Entry into method:getAllBooksOfUser");
		BaseResponse response = new ListBookResponse();
		try {
			List<UserBookVo> data = userBookService.getAllBooksOfUser(userid);
			((ListBookResponse) response).setData(data);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_BOOK_FETCH,
					Constants.SUCCESS_USER_BOOK_FETCH, Constants.USER_BOOK_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_BOOK_FETCH, e.getMessage(),
					Constants.USER_BOOK_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
