package com.blackstar0412.Dao;

import java.sql.SQLException;

import com.blackstar0412.domain.Staff;

public interface StaffDao {
	/**
	 * ����Ա��id��ѯԱ������Ϣ
	 * @param id Ա��id
	 * @return  Ա������Ϣ
	 * @throws SQLException
	 */
	Staff selectStaffById(String id)throws SQLException;
}   
 