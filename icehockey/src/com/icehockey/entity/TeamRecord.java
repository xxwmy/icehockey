package com.icehockey.entity;

import java.util.Date;

public class TeamRecord {
	private int TRecordId;
	private int userId;
	private String userName;
	private int teamId;
	private String teamName;
	private int roleId;
	private String roleName;
	private Date inDate;
	private Date outDate;
	private double score;
	
	public int getTRecordId() {
		return TRecordId;
	}
	public void setTRecordId(int tRecordId) {
		TRecordId = tRecordId;
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
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "TeamRecord [TRecordId=" + TRecordId + ", userId=" + userId
				+ ", userName=" + userName + ", teamId=" + teamId
				+ ", teamName=" + teamName + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", inDate=" + inDate
				+ ", outDate=" + outDate + ", score=" + score + "]";
	}
	public TeamRecord(int tRecordId, int userId, String userName, int teamId,
			String teamName, int roleId, String roleName, Date inDate,
			Date outDate, double score) {
		super();
		TRecordId = tRecordId;
		this.userId = userId;
		this.userName = userName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.inDate = inDate;
		this.outDate = outDate;
		this.score = score;
	}

	
}
