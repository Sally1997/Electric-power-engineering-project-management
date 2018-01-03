package com.holyshit.service;

import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffService {
	
	void delAllStaffs(String[] staffnos,String pno);
	
	PageBean findAllStaffs(String pno,int CurrentPage,int PageSize,String noterno);
	
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
	
	/**\
	 * 搜索公司成员列表
	 * @param pno
	 * @param userno
	 * @return
	 */
	List<Map<String,Object>> queryStaffInCompany(String pno,String userno,String keyword);
	
	/**
	 * 分页查询员工
	 * @param cur
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> findStaffByPage(int cur,int pageSize,Staff condition);
	
	/**
	 * 添加员工
	 * @param staff
	 * @return
	 */
	boolean addStaffByRoot(Staff staff,String password);
	
	/**
	 * 编辑员工信息
	 * @param staff
	 * @param change
	 * @return
	 */
	boolean editStaffInfo(Staff staff,boolean change,String password);
}
