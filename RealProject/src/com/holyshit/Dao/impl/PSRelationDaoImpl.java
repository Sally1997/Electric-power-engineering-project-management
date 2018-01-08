package com.holyshit.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.PSRelationDao;
import com.holyshit.domain.PSRelation;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;

public class PSRelationDaoImpl implements PSRelationDao {

	@Override
	public boolean selectIfInProject(String pno,String staffno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Long l = (Long) qr.query("SELECT COUNT(*) FROM psrelation WHERE pno=? AND staffno=?",
				new ScalarHandler(),pno,staffno);
		boolean x = false;
		if(l==1){
			x=true;
		}
		return x;
	}

	@Override
	public void insertPSRelation(PSRelation psr) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),
				"insert into psrelation(Pno,Staffno,duty) values(?,?,?); ",
				psr.getPno(),psr.getStaffno(),psr.getDuty());
	}

}
