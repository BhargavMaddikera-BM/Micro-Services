package com.app.response.user;

import java.util.List;

import com.app.common.BaseResponse;
import com.app.user.UserVo;

public class ListUserResponse extends BaseResponse{

	private List<UserVo>data;

	public List<UserVo> getData() {
		return data;
	}

	public void setData(List<UserVo> data) {
		this.data = data;
	}

}
