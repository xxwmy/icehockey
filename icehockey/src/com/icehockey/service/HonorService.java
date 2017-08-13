package com.icehockey.service;

import java.util.ArrayList;
import java.util.List;

import com.icehockey.dao.HonorDao;
import com.icehockey.entity.Honor;

public class HonorService {
	
	List<Honor> honors=new ArrayList<Honor>();
	HonorDao honorDao=new HonorDao();
	
	public List<Honor> queryHonorRecordByUserId(String roleName, int userId) {
		honors=honorDao.getHonorRecordByUserId(roleName,userId);
		if(honors!=null){
			for(Honor honor : honors) {
				  System.out.println(honor);
				}
			return honors;
		}else{
			System.out.println("未找到荣誉记录");
			return null;
		}
		
	}
	public List<Honor> queryHonorRecordByUserId(int userId) {
		honors=honorDao.getHonorRecordByUserId(userId);
		if(honors!=null){
			System.out.println("荣誉记录:");
			for(Honor honor : honors) {
				  System.out.println(honor);
				}
			return honors;
		}else{
			System.out.println("未找到荣誉记录");
			return null;
		}
		
	}

}
