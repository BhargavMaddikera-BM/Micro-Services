package com.app.response.book;

import com.app.book.BookVo;
import com.app.common.BaseResponse;

public class BookResponse extends BaseResponse{
	private BookVo data;

	public BookVo getData() {
		return data;
	}

	public void setData(BookVo data) {
		this.data = data;
	}

}
