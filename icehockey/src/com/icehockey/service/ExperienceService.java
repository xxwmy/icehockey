package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.ExperienceDao;
import com.icehockey.entity.Experience;

public class ExperienceService {

	ExperienceDao experienceDao=new ExperienceDao();
	List<Experience> experiences=null;
	public List<Experience> getExperienceByUserId(int userId) {
		experiences=experienceDao.getExperienceByUserId(userId);
		if(experiences!=null){
			for(Experience experience:experiences){
				System.out.println(experience);
			}
			return experiences;
		}else{
			return null;
		}
		
	}

}
