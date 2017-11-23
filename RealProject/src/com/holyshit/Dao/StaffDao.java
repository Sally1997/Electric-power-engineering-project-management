package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.Staff;

public interface StaffDao {
	/**
	 * ����Ա��id��ѯԱ������Ϣ
	 * @param id Ա��id
	 * @return  Ա������Ϣ
	 * @throws SQLException
	 */
	Staff selectStaffById(String id)throws SQLException;
}   
 