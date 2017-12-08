package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.holyshit.Dao.StaffDao;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;
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
	
	public List<StaffDuty> findAllStaffs(String pno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psrelation join  staff on psrelation.staffno=staff.staffno where pno=?", new BeanListHandler<StaffDuty>(StaffDuty.class),pno);
		
	}

	@Override
	public void delAllStaffs(String[] staffnos, String pno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[staffnos.length][];
		for (int i = 0; i < params.length; i++) {
			 params[i] = new Object[]{staffnos[i],pno};
		}
		qr.batch("delete from psrelation where staffno = ? and pno=?", params);
	}
	
	public void addAStaff(PSRelation psr) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into psrelation values(?,?,?); ",psr.getStaffno(),psr.getPno(),psr.getDuty());
	}

}
