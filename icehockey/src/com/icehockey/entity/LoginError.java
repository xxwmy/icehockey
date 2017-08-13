package com.icehockey.entity;

public class LoginError {
	private int errorId;// 问题编号
	private String errorName;// 遇到问题
	private String errorDesc;// 错误简要描述
	private String contactInfo;// 邮箱或者电话

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public LoginError(int errorId, String errorName, String errorDesc,
			String contactInfo) {
		super();
		this.errorId = errorId;
		this.errorName = errorName;
		this.errorDesc = errorDesc;
		this.contactInfo = contactInfo;
	}

	public LoginError() {
		super();
		// TODO Auto-generated constructor stub
	}

}
