package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icehockey.entity.Team;
import com.icehockey.util.DBUtil;

public class TeamDao {

	Team team = null;
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public Team getTeamByTeamName(String teamName) {
		String sql = "SELECT * FROM team where teamName=?;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			System.out.println(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				
				int teamId=rs.getInt("teamId");
				team=new Team(teamId, teamName);
				System.out.println(team);
			} else {
				System.out.println("俱乐部未找到");
				team = null;
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
		return team;
	}

}
