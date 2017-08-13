package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.CompetitionRecord;
import com.icehockey.util.DBUtil;

public class CompetitionRecordDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private CompetitionRecord competitionRecord = null;
	private List<CompetitionRecord> competitionRecords=null;

	public List<CompetitionRecord> getCompetitionRecordByUserId(int userId) {

		String sql = "SELECT competitionrecord.competitionRecordId competitionRecordId, competition.competitionId competitionId, competition.competitionName competitionName, competitionrecord.userId userId, USER .userName userName, competition.competitionType competitionType, competition.hostPlace hostPlace, competition.onDate onDate, competitionrecord.score score FROM competition, competitionrecord, USER WHERE USER .userId = competitionrecord.userId AND competition.competitionId = competitionrecord.competiitionId AND USER .userId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			competitionRecords=new ArrayList<CompetitionRecord>();
			while (rs.next()) {
				int competitionRecordId = rs.getInt("competitionRecordId");// 赛事记录id
				int competitionId = rs.getInt("competitionId");// 赛事id
				String competitionName = rs.getString("competitionName");// 赛事名称
				userId = rs.getInt("userId");// 用户id
				String userName = rs.getString("userName");// 用户姓名
				String competitionType = rs.getString("competitionType");// 赛事类型
				String hostPlace = rs.getString("hostPlace");// 举办地
				Date onDate = rs.getDate("onDate");// 举办日期
				double score = rs.getDouble("score");// 分数
				competitionRecord = new CompetitionRecord(competitionRecordId,
						competitionId, competitionName, userId, userName,
						competitionType, hostPlace, onDate, score);
				competitionRecords.add(competitionRecord);
				return competitionRecords;
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
		return competitionRecords;
	}

	public List<CompetitionRecord> getOfficalCompetitionRecordByUserId(int userId) {

		String sql = "SELECT competitionrecord.competitionRecordId competitionRecordId, competition.competitionId competitionId, competition.competitionName competitionName, competitionrecord.userId userId, USER .userName userName, competition.competitionType competitionType, competition.hostPlace hostPlace, competition.onDate onDate, competitionrecord.score score FROM competition, competitionrecord, USER WHERE USER .userId = competitionrecord.userId AND competition.competitionId = competitionrecord.competiitionId AND competition.competitionType='official'AND USER .userId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			competitionRecords=new ArrayList<CompetitionRecord>();
			while (rs.next()) {
				int competitionRecordId = rs.getInt("competitionRecordId");// 赛事记录id
				int competitionId = rs.getInt("competitionId");// 赛事id
				String competitionName = rs.getString("competitionName");// 赛事名称
				userId = rs.getInt("userId");// 用户id
				String userName = rs.getString("userName");// 用户姓名
				String competitionType = rs.getString("competitionType");// 赛事类型
				String hostPlace = rs.getString("hostPlace");// 举办地
				Date onDate = rs.getDate("onDate");// 举办日期
				double score = rs.getDouble("score");// 分数
				competitionRecord = new CompetitionRecord(competitionRecordId,
						competitionId, competitionName, userId, userName,
						competitionType, hostPlace, onDate, score);
				competitionRecords.add(competitionRecord);
				return competitionRecords;
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
		return competitionRecords;
	}
	
	public List<CompetitionRecord> getInviteCompetitionRecordByUserId(int userId) {

		String sql = "SELECT competitionrecord.competitionRecordId competitionRecordId, competition.competitionId competitionId, competition.competitionName competitionName, competitionrecord.userId userId, USER .userName userName, competition.competitionType competitionType, competition.hostPlace hostPlace, competition.onDate onDate, competitionrecord.score score FROM competition, competitionrecord, USER WHERE USER .userId = competitionrecord.userId AND competition.competitionType='invite' AND competition.competitionId = competitionrecord.competiitionId AND USER .userId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			competitionRecords=new ArrayList<CompetitionRecord>();
			while (rs.next()) {
				int competitionRecordId = rs.getInt("competitionRecordId");// 赛事记录id
				int competitionId = rs.getInt("competitionId");// 赛事id
				String competitionName = rs.getString("competitionName");// 赛事名称
				userId = rs.getInt("userId");// 用户id
				String userName = rs.getString("userName");// 用户姓名
				String competitionType = rs.getString("competitionType");// 赛事类型
				String hostPlace = rs.getString("hostPlace");// 举办地
				Date onDate = rs.getDate("onDate");// 举办日期
				double score = rs.getDouble("score");// 分数
				competitionRecord = new CompetitionRecord(competitionRecordId,
						competitionId, competitionName, userId, userName,
						competitionType, hostPlace, onDate, score);
				competitionRecords.add(competitionRecord);
				return competitionRecords;
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
		return competitionRecords;
	}
}
