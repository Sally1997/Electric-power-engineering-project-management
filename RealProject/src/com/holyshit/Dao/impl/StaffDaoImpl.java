package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.holyshit.Dao.StaffDao;
import com.holyshit.domain.Staff;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
public class StaffDaoImpl implements StaffDao {

	@Override
	public Staff selectStaffById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from staff where staffno=?",new BeanHandler<Staff>(Staff.class),id);
		
	}

	@Override
	public List<Staff> selectNameNoByname(String msg) throws Exception {
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select name,staffno from staff "
				+"where name like ?",new BeanListHandler<Staff>(Staff.class),msg+"%"
				);
	}

}
