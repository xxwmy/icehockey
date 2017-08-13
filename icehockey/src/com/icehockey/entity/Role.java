package com.icehockey.entity;

public class Role {
	private int roleId;
	private String roleName;
	private String roleValue;
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
	public String getRoleValue() {
		return roleValue;
	}
	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleValue=" + roleValue + "]";
	}
	public Role(int roleId, String roleName, String roleValue) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleValue = roleValue;
	}

}
