package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icehockey.entity.Handling;
import com.icehockey.util.DBUtil;

public class HandlingDao {
	Handling handling = null;
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public Handling getHandlingByHandlingValue(String handlingValue) {
		String sql = "SELECT * FROM handling where handlingValue=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, handlingValue);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				
				int handlingId = rs.getInt("handlingId");
				String handlingName = rs.getString("handlingName");
				handling = new Handling(handlingId, handlingName,handlingValue);
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
		return handling;
	}
}
