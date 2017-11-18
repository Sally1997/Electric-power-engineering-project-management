package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.Staff;

public interface StaffDao {
	/**
	 * 根据员工id查询员工的信息
	 * @param id 员工id
	 * @return  员工的信息
	 * @throws SQLException
	 */
	Staff selectStaffById(String id)throws SQLException;
}   
 