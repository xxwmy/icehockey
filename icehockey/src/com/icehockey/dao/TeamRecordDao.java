package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.TeamRecord;
import com.icehockey.util.DBUtil;

public class TeamRecordDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	TeamRecord teamRecord = null;

	List<TeamRecord> teamRecords = null;

	public List<TeamRecord> getTeamRecordByUserId(int userId) {
		String sql = "SELECT * FROM USER, team, teamrecord, role WHERE USER .userId = teamrecord.userId AND team.teamId = teamrecord.teamId AND USER .roleId = role.roleId AND USER .userId =?";
		teamRecords=new ArrayList<TeamRecord>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				 int TRecordId=rs.getInt("TRecordId");
				 //int userId=rs.getInt("userId");
				 String userName=rs.getString("userName");
				 int teamId=rs.getInt("teamId");
				 String teamName=rs.getString("teamName");
				 int roleId=rs.getInt("roleId");
				 String roleName=rs.getString("roleName");
				 Date inDate=rs.getDate("inDate");
				 Date outDate=rs.getDate("outDate");
				 double score=rs.getDouble("score");
				
				
				 teamRecord=new TeamRecord(TRecordId, userId, userName, teamId, teamName, roleId, roleName, inDate, outDate, score);
				 System.out.println(teamRecord);
				 teamRecords.add(teamRecord);
				
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
		return teamRecords;
	}

}
