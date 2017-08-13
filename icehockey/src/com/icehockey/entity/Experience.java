package com.icehockey.entity;

import java.util.Date;

public class Experience {

	private int ERecordId;
	private int userId;
	private String userName;
	private int organizationId;
	private String organizationName;
	private String organizationDegree;	
	private Date onDate;
	
	public Experience(int eRecordId, int userId, String userName,
			int organizationId, String organizationName,
			String organizationDegree, Date onDate) {
		super();
		ERecordId = eRecordId;
		this.userId = userId;
		this.userName = userName;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.organizationDegree = organizationDegree;
		this.onDate = onDate;
	}
	public Date getOnDate() {
		return onDate;
	}
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	
	public String getOrganizationDegree() {
		return organizationDegree;
	}
	public void setOrganizationDegree(String organizationDegree) {
		this.organizationDegree = organizationDegree;
	}

	public int getERecordId() {
		return ERecordId;
	}
	public void setERecordId(int eRecordId) {
		ERecordId = eRecordId;
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
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	@Override
	public String toString() {
		return "Experience [ERecordId=" + ERecordId + ", userId=" + userId
				+ ", userName=" + userName + ", organizationId="
				+ organizationId + ", organizationName=" + organizationName
				+ ", organizationDegree=" + organizationDegree + ", onDate="
				+ onDate + "]";
	}

	
}
