package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffDao {
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
	List<StaffDuty> findAllStaffs(String pno) throws SQLException;
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
	
	
}   
 