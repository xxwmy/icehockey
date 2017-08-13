package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.DegreeRecord;
import com.icehockey.util.DBUtil;

public class DegreeRecordDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private DegreeRecord degreeRecord = null;
	private List<DegreeRecord> degreeRecords=null;
	
	public List<DegreeRecord> getDegreeRecordByUserId(int userId) {

		String sql = "SELECT degreerecord.degreeRecordId degreeRecordId, degreerecord.degreeId degreeId, degree.degreeName degreeName, degreerecord.userId userId, USER .userName userName, degreerecord.onDate onDate FROM degree, degreerecord, USER WHERE USER .userId = degreerecord.userId AND degree.degreeId = degreerecord.degreeId AND USER .userId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			degreeRecords=new ArrayList<DegreeRecord>();
			System.out.println(sql);
			while (rs.next()) {
				
				int degreeRecordId = rs.getInt("degreeRecordId");//等级记录编号
				int degreeId = rs.getInt("degreeId");//等级编号
				String degreeName = rs.getString("degreeName");//等级名称
				userId = rs.getInt("userId");// 用户id
				String userName = rs.getString("userName");// 用户姓名
				Date onDate = rs.getDate("onDate");//获得日期
				
				degreeRecord = new DegreeRecord(degreeRecordId, degreeId, degreeName, userId, userName, onDate);
				degreeRecords.add(degreeRecord);
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
		return degreeRecords;
	}
}
