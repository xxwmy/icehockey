package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icehockey.entity.Role;
import com.icehockey.util.DBUtil;

public class RoleDao {
	Role role = null;
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public Role getRoleByRoleValue(String roleValue) {
		String sql = "SELECT * FROM role where roleValue=?;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, roleValue);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int roleId = rs.getInt("roleId");
				String roleName = rs.getString("roleName");
				role = new Role(roleId, roleName, roleValue);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return role;
	}

	public Role getRoleByRoleId(int roleId) {
		String sql = "SELECT * FROM role where roleId=?;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, roleId);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String roleValue = rs.getString("roleValue");
				String roleName = rs.getString("roleName");
				role = new Role(roleId, roleName, roleValue);
				System.out.println(role);
			}else{
				System.out.println("该角色不存在");
				role=null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return role;
	}
}
