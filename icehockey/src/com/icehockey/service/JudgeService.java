package com.icehockey.service;

import com.icehockey.dao.JudgeDao;
import com.icehockey.entity.Coach;
import com.icehockey.entity.Judge;

public class JudgeService {

	JudgeDao judgeDao=new JudgeDao();
	Judge judge=null;
	Coach coach=null;
	
	public Judge insertJudge(int userId) {
		judge=judgeDao.insertJudge(userId);
		return judge;
	}

}
