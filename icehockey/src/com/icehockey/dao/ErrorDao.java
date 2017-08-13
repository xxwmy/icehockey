package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icehockey.entity.LoginError;
import com.icehockey.util.DBUtil;

public class ErrorDao {
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	LoginError error=null;

	public LoginError getError() {
		String sql = "SELECT * FROM error";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println(sql);
				int errorId = rs.getInt("errorId");
				String errorName = rs.getString("errorName");
				String errorDesc = rs.getString("errorDesc");
				String contactInfo = rs.getString("contactInfo");
				error = new LoginError(errorId, errorName, errorDesc, contactInfo);
				System.out.println(error);
			} else {
				System.out.println("错误");
				error = null;
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
		return error;
	}
	//INSERT INTO 表名称 VALUES (值1, 值2,....)
	public boolean insertError(String errorName, String errorDesc,String contactInfo ) {
		String sql = "INSERT INTO error (errorName, errorDesc, contactInfo)VALUES (?,?,?)";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			System.out.println(sql);
			preparedStatement.setString(1, errorName);
			preparedStatement.setString(2, errorDesc);
			preparedStatement.setString(3, contactInfo);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println(sql);
				System.out.println("插入成功");
				return true;
			} else
				System.out.println("插入失败");
			return false;

		} catch (Exception e) {
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
		return true;
	}
}
