package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.DegreeRecordDao;
import com.icehockey.entity.DegreeRecord;

public class DegreeRecordService {

	DegreeRecordDao dao=new DegreeRecordDao();
	private List<DegreeRecord> degreeRecords=null;
	
	public List<DegreeRecord> queryCoachDegreeByUserId(int userId) {
		degreeRecords = dao.getDegreeRecordByUserId(userId);
		if(degreeRecords!=null){
			System.out.println("找到该用户等级记录......"+degreeRecords.size());
		}
		return degreeRecords;
	}
}
