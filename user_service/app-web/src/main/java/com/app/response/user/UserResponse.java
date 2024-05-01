package com.app.response.user;

import com.app.common.BaseResponse;
import com.app.user.UserVo;

public class UserResponse extends BaseResponse{
	private UserVo data;

	public UserVo getData() {
		return data;
	}

	public void setData(UserVo data) {
		this.data = data;
	}

}
