package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.Honor;
import com.icehockey.util.DBUtil;

public class HonorDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	Honor honor=null;
	List<Honor> honors=null;

	
	public List<Honor> getHonorRecordByUserId(String roleName, int userId) {
		String sql = "SELECT honorrecord.HRecordId AS HRecordId, honorrecord.userId AS userId, USER .userName, honor.honorId AS honorId, honor.honorName, honorrecord.onDate AS onDate FROM honor, honorrecord, USER WHERE USER .userId = honorrecord.userId AND honor.honorId = honorrecord.honorId AND USER .userId =?";
		honors=new ArrayList<Honor>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				 int HRecordId=rs.getInt("HRecordId");
				 int honorId=rs.getInt("honorId");
				 String honorName=rs.getString("honorName");
				 userId=rs.getInt("userId");;
				 String userName=rs.getString("userName");
				 Date onDate=rs.getDate("onDate");
				 honor=new Honor(HRecordId, honorId, honorName, userId, userName, onDate);
				 System.out.println(honor);
				 honors.add(honor);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return honors;
	}
	public List<Honor> getHonorRecordByUserId(int userId) {
		String sql = "SELECT honorrecord.HRecordId AS HRecordId, honorrecord.userId AS userId, USER .userName, honor.honorId AS honorId, honor.honorName, honorrecord.onDate AS onDate FROM honor, honorrecord, USER WHERE USER .userId = honorrecord.userId AND honor.honorId = honorrecord.honorId AND USER .userId =?";
		honors=new ArrayList<Honor>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				 int HRecordId=rs.getInt("HRecordId");
				 int honorId=rs.getInt("honorId");
				 String honorName=rs.getString("honorName");
				 userId=rs.getInt("userId");;
				 String userName=rs.getString("userName");
				 Date onDate=rs.getDate("onDate");
				 honor=new Honor(HRecordId, honorId, honorName, userId, userName, onDate);
				 System.out.println(honor);
				 honors.add(honor);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return honors;
	}

}
