package com.icehockey.entity;

import java.util.Date;

public class Judge {

	private int judgeId;// '裁判员编号',
	private int degreeId;// '等级编号',
	private int workYear;// '执法年限',
	private int supremeOrganizationId;// '执法最高赛事编号'
	private int mostImportantGameId;// '执法最重要赛事编号'

	private int userId;// '登录编号',
	private String weChatId;// '微信账号',
	private String telephone;// '手机号码',
	private String userName;// '用户姓名',
	private int sex;// 1代表男生0表示女生,默认为1男生',
	private String password;// '密码',
	private Date birthday;// '出生日期',
	private String country;// '国籍',
	private String city;// '城市',
	private double height;// '身高',
	private double weight;// '体重',
	private String play;// '爱好：玩雪，玩冰，都玩',
	private String ice_player;// '游戏项目',
	private String snow_play;// '单板，双板，都玩',
	private int roleId;// '角色编号',
	private int handingId;// '持杆方式',
	private String image;// '头像',

	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
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

	public int getSupremeOrganizationId() {
		return supremeOrganizationId;
	}

	public void setSupremeOrganizationId(int supremeOrganizationId) {
		this.supremeOrganizationId = supremeOrganizationId;
	}

	public int getMostImportantGameId() {
		return mostImportantGameId;
	}

	public void setMostImportantGameId(int mostImportantGameId) {
		this.mostImportantGameId = mostImportantGameId;
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

	public Judge(int judgeId, int degreeId, int workYear, int supremeOrganizationId, int mostImportantGameId,
			int userId, String weChatId, String telephone, String userName, int sex, String password, Date birthday,
			String country, String city, double height, double weight, String play, String ice_player, String snow_play,
			int roleId, int handingId, String image) {
		super();
		this.judgeId = judgeId;
		this.degreeId = degreeId;
		this.workYear = workYear;
		this.supremeOrganizationId = supremeOrganizationId;
		this.mostImportantGameId = mostImportantGameId;
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

	@Override
	public String toString() {
		return "Judge [judgeId=" + judgeId + ", degreeId=" + degreeId + ", workYear=" + workYear
				+ ", supremeOrganizationId=" + supremeOrganizationId + ", mostImportantGameId=" + mostImportantGameId
				+ ", userId=" + userId + ", weChatId=" + weChatId + ", telephone=" + telephone + ", userName="
				+ userName + ", sex=" + sex + ", password=" + password + ", birthday=" + birthday + ", country="
				+ country + ", city=" + city + ", height=" + height + ", weight=" + weight + ", play=" + play
				+ ", ice_player=" + ice_player + ", snow_play=" + snow_play + ", roleId=" + roleId + ", handingId="
				+ handingId + ", image=" + image + "]";
	}

}
