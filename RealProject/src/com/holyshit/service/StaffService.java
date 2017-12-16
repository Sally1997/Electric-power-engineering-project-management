package com.holyshit.service;

import java.util.List;
import java.util.Map;

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
	
	/**\
	 * show项目组成员列表 编号、姓名、电话号、该项目下职责和备注
	 * @param pno
	 * @param userno
	 * @return
	 */
	List<Map<String,Object>> showStaffInProject(String pno,String userno);
	
	/**\
	 * show公司成员列表
	 * @param pno
	 * @param userno
	 * @return
	 */
	List<Map<String,Object>> showStaffInCompany(String pno,String userno);
}
