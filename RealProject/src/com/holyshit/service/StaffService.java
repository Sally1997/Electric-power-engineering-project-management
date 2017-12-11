package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffService {
	List<StaffDuty> findAllStaffs(String pno);
	
	void delAllStaffs(String[] staffnos,String pno);
	
	Staff findAStaff(String staffno);
	
	void addAStaff(PSRelation psr);
	
	/**
	 * 判断该人员是否在psrelation关系表中
	 * @param no 人员编号
	 * @return
	 */
	boolean ifInProject(String staffno);
}
