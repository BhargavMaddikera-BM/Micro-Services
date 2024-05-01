package com.app.helper;

import com.app.request.userbook.UserBookRequest;
import com.app.userbook.UserBookVo;

public class ConvertToVoHelper {
	
	private static ConvertToVoHelper convertToVoHelper;
	
	private ConvertToVoHelper(){
		
	}
	
	public static ConvertToVoHelper getInstance(){
		if(convertToVoHelper==null){
			convertToVoHelper=new ConvertToVoHelper();
		}
		return convertToVoHelper;
	}
	
	public UserBookVo convertUserBookRequestToBookVo(UserBookRequest bookRequest){
		UserBookVo userBookVo=new UserBookVo();
		userBookVo.setBookId(bookRequest.getBookId());
		userBookVo.setUserId(bookRequest.getUserId());
		userBookVo.setTimePeriod(bookRequest.getTimePeriod());
		userBookVo.setId(bookRequest.getId());
		userBookVo.setStatus(bookRequest.getStatus());
		return userBookVo;
		
	}
		

}
