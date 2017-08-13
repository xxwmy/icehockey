package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.CoachPlayerDao;
import com.icehockey.entity.CoachPlayer;

public class CoachPlayerService {

	CoachPlayerDao coachPlayerDao = new CoachPlayerDao();
	List<CoachPlayer> coachPlayers = null;

	public List<CoachPlayer> queryCoachPlayerRecordByUserId(String roleName,int userId) {
		coachPlayers = coachPlayerDao.getCoachPlayerRecordByCoachId(roleName,userId);
		if (coachPlayers != null) {
			for (CoachPlayer coachPlayer : coachPlayers) {
				System.out.println(coachPlayer);
			}
			return coachPlayers;
		}
		return null;
	}
	
}
