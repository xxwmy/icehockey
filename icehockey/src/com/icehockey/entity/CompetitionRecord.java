package com.icehockey.entity;

import java.util.Date;

public class CompetitionRecord {
	private int competitionRecordId;//赛事记录id
	private int competitionId;//赛事id
	private String competitionName;//赛事名称
	private int userId;//用户id
	private String userName;//用户姓名
	private String competitionType;//赛事类型
	private String hostPlace;//举办地
	private Date onDate;//举办日期
	private double score;//分数

	public int getCompetitionRecordId() {
		return competitionRecordId;
	}

	public void setCompetitionRecordId(int competitionRecordId) {
		this.competitionRecordId = competitionRecordId;
	}

	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
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

	public String getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(String competitionType) {
		this.competitionType = competitionType;
	}

	public String getHostPlace() {
		return hostPlace;
	}

	public void setHostPlace(String hostPlace) {
		this.hostPlace = hostPlace;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CompetitionRecord [competitionRecordId=" + competitionRecordId
				+ ", competitionId=" + competitionId + ", competitionName="
				+ competitionName + ", userId=" + userId + ", userName="
				+ userName + ", competitionType=" + competitionType
				+ ", hostPlace=" + hostPlace + ", onDate=" + onDate
				+ ", score=" + score + "]";
	}

	public CompetitionRecord(int competitionRecordId, int competitionId,
			String competitionName, int userId, String userName,
			String competitionType, String hostPlace, Date onDate, double score) {
		super();
		this.competitionRecordId = competitionRecordId;
		this.competitionId = competitionId;
		this.competitionName = competitionName;
		this.userId = userId;
		this.userName = userName;
		this.competitionType = competitionType;
		this.hostPlace = hostPlace;
		this.onDate = onDate;
		this.score = score;
	}

	public CompetitionRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

}
