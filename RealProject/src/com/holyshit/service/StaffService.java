package com.holyshit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffService {
	/**
	 * 人员是否在项目组里。
	 * @param staffno
	 * @param pno
	 * @return
	 */
	int isinproject(String staffno,String pno);
	/**
	 * 修改人员的email
	 * @param staffno
	 * @param email
	 */
	void updateemail(String staffno,String email);
	/*
	 * 
	 * 修改人员的联系方式
	 */
	void updatete(String staffno,String te);
	
	void delAllStaffs(String[] staffnos,String pno,String me);
	
	PageBean findAllStaffs(String pno,int CurrentPage,int PageSize,String noterno);
	
	void addAStaff(PSRelation psr,String me);
	
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
	
	List<Map<String,Object>> showStaffInProject(String pno,String userno,int pagenum);
	
	/**\
	 * show公司成员列表
	 * @param pno
	 * @param userno
	 * @return
	 */
	List<Map<String,Object>> showStaffInCompany(String pno,String userno);
	List<Map<String,Object>> showStaffInCompany(String pno,String userno,int pagenum);
	
	/**\
	 * 搜索公司成员列表
	 * @param pno
	 * @param userno
	 * @return
	 */
	List<Map<String,Object>> queryStaffInCompany(String pno,String userno,String keyword);
	List<Map<String,Object>> queryStaffInCompany(String pno,String userno,String keyword,int pagenum);
	
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
	boolean editStaffInfo(Staff staff,boolean change,String password,String changeFlag);
	
	/**
	 * 删除员工信息
	 * @param staffno
	 * @return
	 */
	boolean deleteStaffInfo(String[] staffno);
	
	/**
	 * 员工是否存在
	 * @param staffno
	 * @return
	 */
	boolean isExist(String staffno);
	
	/**
	 * show公司下理想审核权限的人
	 * @param keyword
	 * @return
	 */
	List<Map<String,Object>> showStaffCanSetProject(String keyword);
	
	List<Map<String,Object>> showStaffCanSetProject(String keyword,int pagenum);
	
	/**
	 * 添加人员关系表
	 * @param psr
	 */
	void addAStaff(PSRelation psr);
	
	/**
	 * 获取管理员信息
	 * @return
	 * 
	 */
	Staff findRootInfo();
	
	/**
	 * 是否在项目人员
	 * @param pno
	 * @param staffno
	 * @return
	 */
	boolean selectIfInProject(String pno,String staffno);
}
