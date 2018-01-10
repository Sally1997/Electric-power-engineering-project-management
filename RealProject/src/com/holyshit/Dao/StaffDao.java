package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffDao {
	/**
	 * 查看人员是否在项目组里。
	 * @param staffno
	 * @param pno
	 * @return
	 * @throws SQLException
	 */
	Staff isinproject(String staffno,String pno) throws SQLException;
	/*
	 * 
	 * 修改用户表中的email
	 */
	void updateemail(String staffno,String email) throws SQLException;
	/*
	 * 
	 * 修改用户表中的联系方式te
	 */
	void updatete(String staffno,String te) throws SQLException;
	/**
	 * ����Ա��id��ѯԱ������Ϣ
	 * @param id Ա��id
	 * @return  Ա������Ϣ
	 * @throws SQLException
	 */
	Staff selectStaffById(String id)throws SQLException;
	/**
	 * ������ĵ����Ǹ���ɶ��������
	 */
	
	/**
	 * 通过输入的用户姓名获取到staffname和staffno
	 * @param msg 输入文本信息
	 * @return
	 * @throws Exception
	 */
	List<Staff> selectNameNoByname(String msg)throws Exception;
	/**
	 * 获取员工信息以及职责
	 * @param pno
	 * @return
	 * @throws SQLException
	 */
	List<StaffDuty> findAllStaffs(String pno,int CurrentPage,int PageSize) throws SQLException;
	/**
	 * 删除某个项目的所有成员
	 * @param staffnos  成员id数组
	 * @param pno  项目id
	 * @throws SQLException
	 */
	void delAllStaffs(String[] staffnos,String pno) throws SQLException;
	
	void addAStaff(PSRelation psr) throws SQLException;
	
	/**
	 * 
	 * @param no 编号
	 * @return
	 * @throws SQLException 
	 */
	int selectStaffByNo(String no) throws SQLException;
	int countAllStaffs(String pno) throws SQLException;
	
	/**
	 * 从项目组里面拉人
	 * @param pno 项目编号
	 * @param userno 用户编号
	 * @return 返回项目组人员名单，暂且不排除发布人自己当审核人的情况
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectStaffInProject(String pno,String userno) throws SQLException;
	List<Map<String,Object>> selectStaffInProject(String pno,String userno,int pagenum) throws SQLException;
	List<Object> selectSIP(String pno,String userno) throws SQLException;
	
	/**
	 * 从公司里面拉人
	 * @param pno 项目编号
	 * @param userno 用户编号
	 * @return 
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectStaffInCompany(String pno,String userno) throws SQLException;
	List<Map<String,Object>> selectStaffInCompany(String pno,String userno,int pagenum) throws SQLException;
	List<Object> selectSIC(String pno,String userno) throws SQLException;
	
	/**
	 * 从公司里面搜索人员
	 * @param pno 项目编号
	 * @param userno 用户编号
	 * @return 
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectStaffInCompany(String pno,String userno,String keyword) throws SQLException;
	List<Map<String,Object>> selectStaffInCompany(String pno,String userno,String keyword,int pagenum) throws SQLException;
	List<Object> selectSS(String pno,String userno,String keyword) throws SQLException;
	
	/**
	 * 分页查询所有的员工信息
	 * @param cur
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	List<Staff> selectStaffByPage(int cur,int pageSize,Staff condition) throws SQLException;
	
	/**
	 * 查询员工数量
	 * @return
	 * @throws SQLException
	 */
	long selectStaffNum(Staff condition)throws SQLException;
	
	/**
	 * 添加员工
	 * @param staff
	 * @return
	 * @throws SQLException
	 */
	int addStaff(Staff staff)throws SQLException;
	
	/**
	 * 修改员工信息
	 * @param staff
	 * @return
	 * @throws SQLException
	 */
	int editStaff(Staff staff)throws SQLException;
	
	/**
	 * 从公司删除员工
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	int[] deleteStaff(String[] staffs)throws SQLException;
	
	/**
	 * 搜索有立项权限的员工
	 * @param keyword
	 * @return
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectStaffCanSetProject(String keyword) throws SQLException;
	List<Map<String,Object>> selectStaffCanSetProject(String keyword,int pagenum) throws SQLException;
	List<Object> selectCountSCPP(String keyword) throws SQLException;
	
	/**
	 * 查询人员注册时
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	Staff selectStaffByIdOnRegister(String staffno)throws SQLException;
}   
 