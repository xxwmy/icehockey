package com.icehockey.entity;

public class CoachPlayer {
	private int CPRecord;
	private int coachUserId;
	private String coachName;
	private int playerUserId;
	private String playerName;
	private double bestScore;
	
	public int getCPRecord() {
		return CPRecord;
	}
	public void setCPRecord(int cPRecord) {
		CPRecord = cPRecord;
	}
	public int getCoachUserId() {
		return coachUserId;
	}
	public void setCoachUserId(int coachUserId) {
		this.coachUserId = coachUserId;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public int getPlayerUserId() {
		return playerUserId;
	}
	public void setPlayerUserId(int playerUserId) {
		this.playerUserId = playerUserId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public double getBestScore() {
		return bestScore;
	}
	public void setBestScore(double bestScore) {
		this.bestScore = bestScore;
	}
	@Override
	public String toString() {
		return "CoachPlayer [CPRecord=" + CPRecord + ", coachUserId="
				+ coachUserId + ", coachName=" + coachName + ", playerUserId="
				+ playerUserId + ", playerName=" + playerName + ", bestScore="
				+ bestScore + "]";
	}
	public CoachPlayer(int cPRecord, int coachUserId, String coachName,
			int playerUserId, String playerName, double bestScore) {
		super();
		CPRecord = cPRecord;
		this.coachUserId = coachUserId;
		this.coachName = coachName;
		this.playerUserId = playerUserId;
		this.playerName = playerName;
		this.bestScore = bestScore;
	}
	
	
}
