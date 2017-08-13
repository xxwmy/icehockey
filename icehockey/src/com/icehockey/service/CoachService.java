package com.icehockey.service;


import com.icehockey.dao.ClubDao;
import com.icehockey.dao.CoachDao;
import com.icehockey.dao.TeamDao;
import com.icehockey.entity.Club;
import com.icehockey.entity.Coach;
import com.icehockey.entity.Team;

public class CoachService {
	
	ClubService clubService=new ClubService();
	TeamService teamService=new TeamService();
	
	CoachDao coachDao=new CoachDao();
	ClubDao clubDao=new ClubDao();
	TeamDao teamDao=new TeamDao();
	
	Club club=null;
	Coach coach=null;
	Team team=null;
	
	public Coach queryCoachByCoachName(String coachName){
		coach=coachDao.getCoachByCoachName(coachName);
		return coach;
	}
	public Coach insertCoach(int userId) {
		coach=coachDao.insertCoach(userId);
		return coach;
	}
	public Coach updateCoach(int userId, String xianxiaolijvlebu, String xianshuqiudui) {
		club=clubService.getClubByClubName(xianxiaolijvlebu);
		int nowTeachClubId=club.getClubId();
		
		team=teamService.getTeamByTeamName(xianshuqiudui);
		int nowTeachTeamId=team.getTeamId();
		
		coach=coachDao.updateCoach(userId,nowTeachClubId,nowTeachTeamId);
		return coach;
	}
	public Coach queryCoachByUserId(int userId) {
		coach=coachDao.getCoachByUserId(userId);
		return coach;
	}
}
