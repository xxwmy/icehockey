package com.icehockey.service;

import com.icehockey.dao.RoleDao;
import com.icehockey.entity.Role;

public class RoleService {

	RoleDao dao=new RoleDao();
	Role role=null;
	public Role queryRole(int roleId) {
		role=dao.getRoleByRoleId(roleId);
		if(role!=null){
			System.out.println(role.toString());
		}
		return role;
	}

}
