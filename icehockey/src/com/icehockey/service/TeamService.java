package com.icehockey.service;

import com.icehockey.dao.TeamDao;
import com.icehockey.entity.Team;

public class TeamService {

	TeamDao teamDao=new TeamDao();
	Team team=null;
	
	public Team getTeamByTeamName(String teamName) {
		team=teamDao.getTeamByTeamName(teamName);
		return team;
	}

}
