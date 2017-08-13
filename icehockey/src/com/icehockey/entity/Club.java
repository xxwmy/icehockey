package com.icehockey.entity;

import java.util.Date;

public class Club {
	private int clubId;// '俱乐部编号',
	private String clubName;// '俱乐部名称',
	private String organization;// '所属机构',
	private String clubManager;// '俱乐部主席',
	private String address;// '所在地',
	private String managementContent;// '经营内容',
	private String telephone;// '联系方式',
	private Date buildTime;// '组建时间',
	private String resource;// '场地资源',
	private String construct;// '球队建设',
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getClubManager() {
		return clubManager;
	}
	public void setClubManager(String clubManager) {
		this.clubManager = clubManager;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getManagementContent() {
		return managementContent;
	}
	public void setManagementContent(String managementContent) {
		this.managementContent = managementContent;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getConstruct() {
		return construct;
	}
	public void setConstruct(String construct) {
		this.construct = construct;
	}
	public Club(int clubId, String clubName, String organization, String clubManager, String address,
			String managementContent, String telephone, Date buildTime, String resource, String construct) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.organization = organization;
		this.clubManager = clubManager;
		this.address = address;
		this.managementContent = managementContent;
		this.telephone = telephone;
		this.buildTime = buildTime;
		this.resource = resource;
		this.construct = construct;
		
	}
	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", organization=" + organization + ", clubManager="
				+ clubManager + ", address=" + address + ", managementContent=" + managementContent + ", telephone="
				+ telephone + ", buildTime=" + buildTime + ", resource=" + resource + ", construct=" + construct + "]";
	}
	
}
