package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffService {
	
	void delAllStaffs(String[] staffnos,String pno);
	
	PageBean findAllStaffs(String pno,int CurrentPage,int PageSize);
	
	void addAStaff(PSRelation psr);
	
	/**
	 * 判断该人员是否在psrelation关系表中
	 * @param no 人员编号
	 * @return
	 */
	boolean ifInProject(String staffno);

	Staff findAStaff(String staffno);
}
