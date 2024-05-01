package com.app.response.book;

import com.app.common.BaseResponse;
import com.app.userbook.UserBookVo;

public class BookResponse extends BaseResponse{
	private UserBookVo data;

	public UserBookVo getData() {
		return data;
	}

	public void setData(UserBookVo data) {
		this.data = data;
	}

}
