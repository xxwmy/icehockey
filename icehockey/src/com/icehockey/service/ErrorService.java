package com.icehockey.service;

import com.icehockey.dao.ErrorDao;

public class ErrorService {
	ErrorDao dao=new ErrorDao();
	public boolean insertError(String errorName, String errorDesc,String contactInfo){
		boolean t=dao.insertError(errorName, errorDesc, contactInfo);
		return t;
	}
}
