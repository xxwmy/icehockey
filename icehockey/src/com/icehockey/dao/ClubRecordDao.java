package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.ClubRecord;
import com.icehockey.util.DBUtil;

public class ClubRecordDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	List<ClubRecord> clubRecords = null;
	ClubRecord clubRecord = null;

	public List<ClubRecord> getClubRecordByUserId(int userId) {
		String sql = "SELECT * FROM USER, club, clubrecord WHERE USER .userId = clubrecord.userId AND club.clubId = clubrecord.clubId AND USER .userId =?";

		clubRecords = new ArrayList<ClubRecord>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				int CRecordId = rs.getInt("CRecordId");
				int clubId = rs.getInt("clubId");
				String clubName = rs.getString("clubName");
				String userName = rs.getString("userName");
				String organization = rs.getString("organization");
				String clubManager = rs.getString("clubManager");
				String address = rs.getString("address");
				String managementContent = rs.getString("managementContent");
				String telephone = rs.getString("telephone");
				Date buildTime = rs.getDate("buildTime");
				String resource = rs.getString("resource");
				String construct = rs.getString("construct");

				Date inDate = rs.getDate("inDate");
				Date outDate = rs.getDate("outDate");
				clubRecord = new ClubRecord(CRecordId, clubId, clubName, userId, userName, organization, clubManager, address, managementContent, telephone, buildTime, resource, construct, inDate, outDate);
				System.out.println(clubRecord);
				clubRecords.add(clubRecord);

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
		return clubRecords;
	}

}
