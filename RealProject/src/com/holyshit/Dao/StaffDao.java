package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Staff;

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


}   
 