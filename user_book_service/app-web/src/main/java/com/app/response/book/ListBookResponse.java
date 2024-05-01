package com.app.response.book;

import java.util.List;

import com.app.common.BaseResponse;
import com.app.userbook.UserBookVo;

public class ListBookResponse extends BaseResponse{

	private List<UserBookVo>data;

	public List<UserBookVo> getData() {
		return data;
	}

	public void setData(List<UserBookVo> data) {
		this.data = data;
	}

}
