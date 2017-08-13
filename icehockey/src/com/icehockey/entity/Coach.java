package com.icehockey.entity;

import java.util.Date;

public class Coach {

	private int coachId;//'教练员编号',
	
	private int catagoryId;//'类别编号',
	private int degreeId;//'等级编号',
	private int workYear;// '执法年限',
	private int nowTeachClubId;// '现执教俱乐部',
	private int everTeachCloudId;// '曾执教俱乐部',
	private int nowTeachTeamId;// '现执教球队',
	private int everTeachTeamId;// '曾执教球队',
	private int nowTeachTeamScore;// '现执教球队最佳战绩',
	private int everTeachTeamScore;// '曾执教球队最佳战绩',

	private int userId;// '用户编号',
	private String weChatId;// '微信账号',
	private String telephone;//'手机号码',
	private String userName;//'用户姓名',
	private int sex;//1代表男生0表示女生,默认为1男生',
	private String password;// '密码',
	private Date birthday;//'出生日期',
	private String country;//'国籍',
	private String city;//'城市',
	private double height;// '身高',
	private double weight;// '体重',
	private String play;//'爱好：玩雪，玩冰，都玩',
	private String ice_player;// '游戏项目',
	private String snow_play;// '单板，双板，都玩',
	private int roleId;// '角色编号',
	private int handingId;// '持杆方式',
	private String image;// '头像',
	
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public int getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public int getWorkYear() {
		return workYear;
	}
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}
	public int getNowTeachClubId() {
		return nowTeachClubId;
	}
	public void setNowTeachClubId(int nowTeachClubId) {
		this.nowTeachClubId = nowTeachClubId;
	}
	public int getEverTeachCloudId() {
		return everTeachCloudId;
	}
	public void setEverTeachCloudId(int everTeachCloudId) {
		this.everTeachCloudId = everTeachCloudId;
	}
	public int getNowTeachTeamId() {
		return nowTeachTeamId;
	}
	public void setNowTeachTeamId(int nowTeachTeamId) {
		this.nowTeachTeamId = nowTeachTeamId;
	}
	public int getEverTeachTeamId() {
		return everTeachTeamId;
	}
	public void setEverTeachTeamId(int everTeachTeamId) {
		this.everTeachTeamId = everTeachTeamId;
	}
	public int getNowTeachTeamScore() {
		return nowTeachTeamScore;
	}
	public void setNowTeachTeamScore(int nowTeachTeamScore) {
		this.nowTeachTeamScore = nowTeachTeamScore;
	}
	public int getEverTeachTeamScore() {
		return everTeachTeamScore;
	}
	public void setEverTeachTeamScore(int everTeachTeamScore) {
		this.everTeachTeamScore = everTeachTeamScore;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getWeChatId() {
		return weChatId;
	}
	public void setWeChatId(String weChatId) {
		this.weChatId = weChatId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getPlay() {
		return play;
	}
	public void setPlay(String play) {
		this.play = play;
	}
	public String getIce_player() {
		return ice_player;
	}
	public void setIce_player(String ice_player) {
		this.ice_player = ice_player;
	}
	public String getSnow_play() {
		return snow_play;
	}
	public void setSnow_play(String snow_play) {
		this.snow_play = snow_play;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getHandingId() {
		return handingId;
	}
	public void setHandingId(int handingId) {
		this.handingId = handingId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", catagoryId=" + catagoryId + ", degreeId=" + degreeId + ", workYear="
				+ workYear + ", nowTeachClubId=" + nowTeachClubId + ", everTeachCloudId=" + everTeachCloudId
				+ ", nowTeachTeamId=" + nowTeachTeamId + ", everTeachTeamId=" + everTeachTeamId + ", nowTeachTeamScore="
				+ nowTeachTeamScore + ", everTeachTeamScore=" + everTeachTeamScore + ", userId=" + userId
				+ ", weChatId=" + weChatId + ", telephone=" + telephone + ", userName=" + userName + ", sex=" + sex
				+ ", password=" + password + ", birthday=" + birthday + ", country=" + country + ", city=" + city
				+ ", height=" + height + ", weight=" + weight + ", play=" + play + ", ice_player=" + ice_player
				+ ", snow_play=" + snow_play + ", roleId=" + roleId + ", handingId=" + handingId + ", image=" + image
				+ "]";
	}
	public Coach(int coachId, int catagoryId, int degreeId, int workYear, int nowTeachClubId, int everTeachCloudId,
			int nowTeachTeamId, int everTeachTeamId, int nowTeachTeamScore, int everTeachTeamScore, int userId,
			String weChatId, String telephone, String userName, int sex, String password, Date birthday, String country,
			String city, double height, double weight, String play, String ice_player, String snow_play, int roleId,
			int handingId, String image) {
		super();
		this.coachId = coachId;
		this.catagoryId = catagoryId;
		this.degreeId = degreeId;
		this.workYear = workYear;
		this.nowTeachClubId = nowTeachClubId;
		this.everTeachCloudId = everTeachCloudId;
		this.nowTeachTeamId = nowTeachTeamId;
		this.everTeachTeamId = everTeachTeamId;
		this.nowTeachTeamScore = nowTeachTeamScore;
		this.everTeachTeamScore = everTeachTeamScore;
		this.userId = userId;
		this.weChatId = weChatId;
		this.telephone = telephone;
		this.userName = userName;
		this.sex = sex;
		this.password = password;
		this.birthday = birthday;
		this.country = country;
		this.city = city;
		this.height = height;
		this.weight = weight;
		this.play = play;
		this.ice_player = ice_player;
		this.snow_play = snow_play;
		this.roleId = roleId;
		this.handingId = handingId;
		this.image = image;
	}

	
	
}
