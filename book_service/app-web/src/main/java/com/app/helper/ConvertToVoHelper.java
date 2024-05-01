package com.app.helper;

import com.app.book.BookVo;
import com.app.request.book.BookRequest;

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
	
	public BookVo convertBookRequestToBookVo(BookRequest bookRequest){
		BookVo bookVo=new BookVo();
		bookVo.setId(bookRequest.getId());
		bookVo.setAuthorName(bookRequest.getAuthorName());
		bookVo.setBookId(bookRequest.getBookId());
		bookVo.setBookName(bookRequest.getBookName());
		bookVo.setPublisher(bookRequest.getPublisher());
		return bookVo;
		
	}
		

}
