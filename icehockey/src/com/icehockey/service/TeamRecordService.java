package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.TeamRecordDao;
import com.icehockey.entity.TeamRecord;

public class TeamRecordService {

	//TeamRecord teamRecord=null;
	TeamRecordDao teamRecordDao=new TeamRecordDao();
	List<TeamRecord> teamRecords=null;
	
	public List<TeamRecord> queryTeamRecordByUserId(int userId) {
		teamRecords=teamRecordDao.getTeamRecordByUserId(userId);
		if(teamRecords!=null){
			for(TeamRecord teamRecord:teamRecords){
				System.out.println(teamRecord);
			}
			return teamRecords;
		}
		return null;
	}

}
