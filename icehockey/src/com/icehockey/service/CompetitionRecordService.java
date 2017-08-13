package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.CompetitionRecordDao;
import com.icehockey.entity.CompetitionRecord;

public class CompetitionRecordService {

	CompetitionRecordDao dao=new CompetitionRecordDao();
	private List<CompetitionRecord> competitionRecords=null;
	
	public List<CompetitionRecord> queryByUserId(int userId) {
		competitionRecords = dao.getCompetitionRecordByUserId(userId);
		if(competitionRecords!=null){
			System.out.println("找到该球员赛事记录......"+competitionRecords);
		}
		return competitionRecords;
	}
	public List<CompetitionRecord> queryInviteCompetitionByUserId(int userId) {
		competitionRecords = dao.getInviteCompetitionRecordByUserId(userId);
		if(competitionRecords!=null){
			System.out.println("找到该球员赛事记录......"+competitionRecords);
		}
		return competitionRecords;
	}
	public List<CompetitionRecord> queryOfficalCompetitionByUserId(int userId) {
		competitionRecords = dao.getOfficalCompetitionRecordByUserId(userId);
		if(competitionRecords!=null){
			System.out.println("找到该球员赛事记录......"+competitionRecords);
		}
		return competitionRecords;
	}
}
