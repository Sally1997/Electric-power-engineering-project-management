package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.holyshit.Dao.AuditDao;
import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.utils.C3P0Util;
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

	@Override
	public void insertpdocaudit(PDocAudit pda) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO pdocaudit "+
					"(pdocno,pno,applicantno,auditorno,auditstate) VALUES(?,?,?,?,?)", 
					pda.getPdocno(),pda.getPno(),pda.getApplicantno(),pda.getAuditorno(),pda.getAuditstate());
	}

	@Override
	public Map<String, Object> selectProAuditInfo(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT pname,pbudget,ptype,stime,etime,NAME,DTitle,DPath "+
				"FROM project,staff,document,projaprlaudit,pdocaudit "+
				"WHERE projaprlaudit.paauditno= ? AND projaprlaudit.PNo=pdocaudit.PNo "+
				"AND pdocaudit.PDocNo=document.DNo AND projaprlaudit.ApplicantNo=staff.StaffNo "+
				"AND project.pno=projaprlaudit.PNo ", new MapHandler(),mno);
	}

	@Override
	public List<Map<String, Object>> selectProAuditAdvInfo(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT NAME,auditadv,auditstate,audittime FROM projaprlaudit,staff "+
				"WHERE staffno=AuditorNo AND pno IN (SELECT pno FROM projaprlaudit "+
				"WHERE paauditno=?)", new MapListHandler(),mno);
	}

}
