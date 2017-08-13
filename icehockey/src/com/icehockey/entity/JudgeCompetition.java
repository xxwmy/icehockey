package com.icehockey.entity;

import java.util.Date;

public class JudgeCompetition {
	private int JCId;
	private int judgeId;
	private String judgeName;
	private String competiitionName;
	private Date onDate;

	public int getJCId() {
		return JCId;
	}

	public void setJCId(int jCId) {
		JCId = jCId;
	}

	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}

	public String getJudgeName() {
		return judgeName;
	}

	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}

	public String getCompetiitionName() {
		return competiitionName;
	}

	public void setCompetiitionName(String competiitionName) {
		this.competiitionName = competiitionName;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	@Override
	public String toString() {
		return "JudgeCompetition [JCId=" + JCId + ", judgeId=" + judgeId
				+ ", judgeName=" + judgeName + ", competiitionName="
				+ competiitionName + ", onDate=" + onDate + "]";
	}

	public JudgeCompetition(int jCId, int judgeId, String judgeName,
			String competiitionName, Date onDate) {
		super();
		JCId = jCId;
		this.judgeId = judgeId;
		this.judgeName = judgeName;
		this.competiitionName = competiitionName;
		this.onDate = onDate;
	}

}
