package com.icehockey.entity;

import java.util.Date;

public class DegreeRecord {
	private int degreeRecordId;//等级记录编号
	private int degreeId;//等级编号
	private String degreeName;//等级名称
	private int userId;//用户编号
	private String userName;//用户姓名
	private Date onDate;//获得日期
	public int getDegreeRecordId() {
		return degreeRecordId;
	}
	public void setDegreeRecordId(int degreeRecordId) {
		this.degreeRecordId = degreeRecordId;
	}
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
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
		return "DegreeRecord [degreeRecordId=" + degreeRecordId + ", degreeId="
				+ degreeId + ", degreeName=" + degreeName + ", userId="
				+ userId + ", userName=" + userName + ", onDate=" + onDate
				+ "]";
	}
	public DegreeRecord(int degreeRecordId, int degreeId, String degreeName,
			int userId, String userName, Date onDate) {
		super();
		this.degreeRecordId = degreeRecordId;
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.userId = userId;
		this.userName = userName;
		this.onDate = onDate;
	}
	public DegreeRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
