package com.holyshit.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.utils.ConnectionManager;

public class AuthorityDaoImpl implements AuthorityDao {

	@Override
	public int selectHasPermission(String staffno, int perno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Long res = (Long) qr.query(ConnectionManager.getConnection(), "select count(*) from asrelation where staffno=? and perno=?",new ScalarHandler(),staffno,perno);
		return Integer.parseInt(res.toString());
	
	}

}
