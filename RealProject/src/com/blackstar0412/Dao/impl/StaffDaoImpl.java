package com.blackstar0412.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.blackstar0412.Dao.StaffDao;
import com.blackstar0412.domain.Staff;
import com.blackstar0412.utils.ConnectionManager;

public class StaffDaoImpl implements StaffDao {

	@Override
	public Staff selectStaffById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=?",new BeanHandler<Staff>(Staff.class),id);
		
	}

}
