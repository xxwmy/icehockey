package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.JudgeCompetition;
import com.icehockey.util.DBUtil;

public class JudgeCompetitionDao {
	
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	
	List<JudgeCompetition> competitions=null;	
	JudgeCompetition judgeCompetition=null;
	
	public List<JudgeCompetition> getJudgeExpByUserId(int userId) {
		
		String sql="SELECT * FROM USER, judgecompetition WHERE USER .userId = judgecompetition.judgeUserId and user.userId=?";
		
		competitions=new ArrayList<JudgeCompetition>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				 int JCId=rs.getInt("JCId");
				 int judgeId=rs.getInt("judgeUserId");
				 String judgeName=rs.getString("userName");
				 String competiitionName=rs.getString("competiitionName");
				 Date onDate=rs.getDate("onDate");

				 judgeCompetition=new JudgeCompetition(JCId, judgeId, judgeName, competiitionName, onDate);
				 competitions.add(judgeCompetition);
				 
				 
				
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
		return competitions;
	}

}
