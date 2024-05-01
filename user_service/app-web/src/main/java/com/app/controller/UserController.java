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
import com.app.UserService;
import com.app.common.BaseController;
import com.app.common.BaseResponse;
import com.app.common.Constants;
import com.app.helper.ConvertToVoHelper;
import com.app.request.common.JSONObject;
import com.app.request.user.UserRequest;
import com.app.response.user.ListUserResponse;
import com.app.response.user.UserResponse;
import com.app.user.UserVo;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController extends BaseController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/v1", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> createUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<UserRequest> userRequest) {
		logger.info("Entry into method:createUser");
		BaseResponse response = new UserResponse();
		try {
			logger.info("Request Payload:" + generateRequestAndResponseLogPaylod(userRequest));
			UserVo userVo = ConvertToVoHelper.getInstance().convertUserRequestToUserVo((userRequest.getData()));
			userVo = userService.createUser(userVo);
			((UserResponse) response).setData(userVo);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_CREATION,
					Constants.SUCCESS_USER_CREATION, Constants.USER_CREATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			if (e.getCause() != null) {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_CREATION,
						e.getCause().getMessage(), Constants.USER_CREATED_UNSUCCESSFULLY);
			} else {
				response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_CREATION,
						e.getMessage(), Constants.USER_CREATED_UNSUCCESSFULLY);
			}
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/v1", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> updateUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody JSONObject<UserRequest> userRequest) {
		logger.info("Entry into method:updateUser");
		BaseResponse response = new UserResponse();
		try {
			logger.info("Request Payload:" + generateRequestAndResponseLogPaylod(userRequest));
			UserVo userVo = ConvertToVoHelper.getInstance().convertUserRequestToUserVo((userRequest.getData()));
			userVo = userService.updateUser(userVo);
			((UserResponse) response).setData(userVo);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_UPDATION,
					Constants.SUCCESS_USER_UPDATION, Constants.USER_UPDATED_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_UPDATION, e.getMessage(),
					Constants.USER_UPDATED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/v1/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BaseResponse> deleteUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int id) {
		logger.info("Entry into method:deleteUser");
		BaseResponse response = new UserResponse();
		try {
			UserVo userVo = userService.deleteUser(id);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_DELETION,
					Constants.SUCCESS_USER_DELETION, Constants.USER_DELETED_SUCCESSFULLY);

			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_DELETION, e.getMessage(),
					Constants.USER_DELETED_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/v1")
	public ResponseEntity<BaseResponse> getAllUsers(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		logger.info("Entry into method:getAllUsers");
		BaseResponse response = new ListUserResponse();
		try {
			List<UserVo> listAllUsers = userService.getAllUsers();
			((ListUserResponse) response).setData(listAllUsers);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_FETCH,
					Constants.SUCCESS_USER_FETCH, Constants.USER_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_FETCH, e.getMessage(),
					Constants.USER_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/v1/{id}")
	public ResponseEntity<BaseResponse> getUserDetails(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@PathVariable int id) {
		logger.info("Entry into method:getUserDetails");
		BaseResponse response = new UserResponse();
		try {
			UserVo data = userService.getUserDetails(id);
			((UserResponse) response).setData(data);
			response = constructResponse(response, Constants.SUCCESS, Constants.SUCCESS_USER_FETCH,
					Constants.SUCCESS_USER_FETCH, Constants.USER_FETCH_SUCCESSFULLY);
			logger.info("Response Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = constructResponse(response, Constants.FAILURE, Constants.FAILURE_USER_FETCH, e.getMessage(),
					Constants.USER_FETCH_UNSUCCESSFULLY);
			logger.error("Error Payload:" + generateRequestAndResponseLogPaylod(response));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
