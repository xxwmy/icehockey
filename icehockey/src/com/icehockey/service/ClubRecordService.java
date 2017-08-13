package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.ClubRecordDao;
import com.icehockey.entity.ClubRecord;

public class ClubRecordService {
	List<ClubRecord> clubRecords=null;
	ClubRecordDao clubRecordDao=new ClubRecordDao();
	
	public List<ClubRecord> queryClubRecordByUserId( int userId) {
		clubRecords=clubRecordDao.getClubRecordByUserId(userId);
		if(clubRecords!=null){
			for(ClubRecord clubRecord:clubRecords){
				System.out.println(clubRecord);
			}
			return clubRecords;
		}
		return null;
	}

}
