package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.UserBookService;
import com.app.common.BaseController;
import com.app.common.BaseResponse;
import com.app.common.Constants;
import com.app.response.inventory_book.InventoryCountponse;

@RestController
@CrossOrigin
@RequestMapping("inventory/book")
public class InventoryBookController extends BaseController {

	@Autowired
	UserBookService userBookService;

	private static final Logger logger = LoggerFactory.getLogger(InventoryBookController.class);

	@RequestMapping(value = "/v1/{bookid}")
	public ResponseEntity<BaseResponse> getInventoryOfaBook(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int bookid) {
		logger.info("Entry into method:getInventoryOfaBook");
		BaseResponse response = new InventoryCountponse();
		try {
			int count = userBookService.getInventoryOfaBook(bookid);
			((InventoryCountponse) response).setData(count);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_INVENTORY_COUNT_FETCH,
					Constants.SUCCESS_INVENTORY_COUNT_FETCH, Constants.INVENTORY_COUNT_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_INVENTORY_COUNT_FETCH, e.getMessage(),
					Constants.INVENTORY_COUNT_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
