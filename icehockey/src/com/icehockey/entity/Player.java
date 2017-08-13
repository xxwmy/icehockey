package com.icehockey.entity;

public class Player {

	private int playerId;// 球员编号
	private int userId;// `用户编号
	private int firstlearningAge;// '初学年龄',
	private String groupName;// '组别',

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getFirstlearningAge() {
		return firstlearningAge;
	}

	public void setFirstlearningAge(int firstlearningAge) {
		this.firstlearningAge = firstlearningAge;
	}

	public String getgroupName() {
		return groupName;
	}

	public void setgroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstlearningAge="
				+ firstlearningAge + ", groupName=" + groupName + ", userId="
				+ userId + "]";
	}

	public Player(int playerId, int userId, int firstlearningAge,
			String groupName) {
		super();
		this.playerId = playerId;
		this.firstlearningAge = firstlearningAge;
		this.groupName = groupName;
		this.userId = userId;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

}
