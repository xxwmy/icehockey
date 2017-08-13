package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.entity.Experience;
import com.icehockey.entity.Honor;
import com.icehockey.util.DBUtil;

public class ExperienceDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	Honor honor=null;
	List<Experience> experiences=null;
	Experience experience=null;
	
	public List<Experience> getExperienceByUserId(int userId) {
		String sql = "SELECT experience.ERecordId, experience.userId, USER .userName, experience.organizationId, organization.organizationName, organization.organizationDegree, experience.onDate FROM experience, USER, organization WHERE USER .userId = experience.userId AND organization.organizationId = experience.organizationId AND USER .userId = ?";
		
		experiences=new ArrayList<Experience>();
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			System.out.println(sql);
			while (rs.next()) {

				 int ERecordId=rs.getInt("ERecordId");
				 userId=rs.getInt("userId");
				 String userName=rs.getString("userName");
				 int organizationId=rs.getInt("organizationId");
				 String organizationName=rs.getString("organizationName");
				 String organizationDegree=rs.getString("organizationDegree");	
				 Date onDate=rs.getDate("onDate");
				 experience=new Experience(ERecordId, userId, userName, organizationId, organizationName, organizationDegree, onDate);
				 experiences.add(experience);
				 
				 
				
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
		return experiences;
	}

}
