package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.JudgeCompetitionDao;
import com.icehockey.entity.JudgeCompetition;

public class JudgeCompetitionService {

	List<JudgeCompetition> competitions=null;
	JudgeCompetitionDao competitionDao=new JudgeCompetitionDao();
	
	public List<JudgeCompetition> queryJudgeExpByUserId(int userId) {
		competitions = competitionDao.getJudgeExpByUserId(userId);
		if (competitions != null) {
			for (JudgeCompetition competition : competitions) {
				System.out.println(competition);
			}
			return competitions;
		}
		return null;
	}

}
