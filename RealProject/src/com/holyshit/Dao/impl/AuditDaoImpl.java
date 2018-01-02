package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.holyshit.Dao.AuditDao;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.utils.ConnectionManager;

public class AuditDaoImpl implements AuditDao {

	@Override
	public List<Object> selectAuditedPro(String staffno) {
		
		return null;
	}
	
	@Override
	public void insertprojaprlaudit(Projaprlaudit paa) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO projaprlaudit "+
					"(pno,applicantno,auditorno,auditstate) VALUES(?,?,?,?)", 
					paa.getPno(),paa.getApplicantno(),paa.getAuditorno(),paa.getAuditstate());
	}

}
