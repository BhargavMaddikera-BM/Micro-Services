package com.app.response.book;

import java.util.List;

import com.app.book.BookVo;
import com.app.common.BaseResponse;

public class ListBookResponse extends BaseResponse{

	private List<BookVo>data;

	public List<BookVo> getData() {
		return data;
	}

	public void setData(List<BookVo> data) {
		this.data = data;
	}

}
