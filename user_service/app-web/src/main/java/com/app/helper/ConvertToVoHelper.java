package com.app.helper;

import com.app.request.user.UserRequest;
import com.app.user.UserVo;

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
	
	public UserVo convertUserRequestToUserVo(UserRequest userRequest){
		UserVo userVo=new UserVo();
		userVo.setUserId(userRequest.getUserId());
		userVo.setId(userRequest.getId());
		userVo.setUserName(userRequest.getUserName());
		userVo.setCreatedDate(userRequest.getCreatedDate());
		userVo.setMembershipActive(userRequest.isMembershipActive());
		return userVo;
		
	}
		

}
