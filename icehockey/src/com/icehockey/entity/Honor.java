package com.icehockey.entity;

import java.util.Date;

public class Honor {
	private int HRecordId;
	private int honorId;
	private String honorName;
	private int userId;
	private String userName;
	private Date onDate;
	
	public int getHRecordId() {
		return HRecordId;
	}
	public void setHRecordId(int hRecordId) {
		HRecordId = hRecordId;
	}
	public int getHonorId() {
		return honorId;
	}
	public void setHonorId(int honorId) {
		this.honorId = honorId;
	}
	public String getHonorName() {
		return honorName;
	}
	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOnDate() {
		return onDate;
	}
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	@Override
	public String toString() {
		return "Honor [HRecordId=" + HRecordId + ", honorId=" + honorId
				+ ", honorName=" + honorName + ", userId=" + userId
				+ ", userName=" + userName + ", onDate=" + onDate + "]";
	}
	public Honor(int hRecordId, int honorId, String honorName, int userId,
			String userName, Date onDate) {
		super();
		HRecordId = hRecordId;
		this.honorId = honorId;
		this.honorName = honorName;
		this.userId = userId;
		this.userName = userName;
		this.onDate = onDate;
	}

	
	
	
}
