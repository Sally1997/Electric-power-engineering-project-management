package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
		return qr.query("SELECT pname,pbudget,ptype,stime,etime,NAME,DTitle,DNo,staffno "+
				"FROM project,staff,document,projaprlaudit,pdocaudit "+
				"WHERE projaprlaudit.paauditno=? AND projaprlaudit.PNo=pdocaudit.PNo "+
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

	@Override
	public void updateProAuditInfo(String mno, String auditstate,
			String auditadv, String NAuditorNo) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(), "UPDATE projaprlaudit SET auditstate=?, "+
				"NAuditorNo=?,auditadv=?,audittime=CURRENT_TIMESTAMP() WHERE paauditno =? ",
				auditstate,NAuditorNo,auditadv,mno);
	}

	@Override
	public Projaprlaudit selectPAAByMno(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT * FROM projaprlaudit WHERE paauditno IN (SELECT busno FROM inform WHERE mno=?)"
				, new BeanHandler<Projaprlaudit>(Projaprlaudit.class),mno);
	}

	@Override
	public Map<String, Object> selectDocAudit(String pdauditno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT dno,UloadPNo,name,DTitle,ftype,dtype,FSize,UploadTime FROM document,pdocaudit,staff "+
				"WHERE document.DNo=pdocaudit.pdocno AND UloadPNo=staffno AND pdauditno=?", new MapHandler(),pdauditno);
	}

	@Override
	public Map<String, Object> selectStageAudit(String stageno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT pname,stageno,sname,charpno,NAME,psplan.stime,psplan.etime,psplan.budget "+
				"FROM psplan,project,staff WHERE stageno=? AND project.pno=psplan.PNo AND staffno=charpno", 
				new MapHandler(),stageno);
		
	}

	@Override
	public Map<String, Object> selectTaskAudit(String taskno) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT pname,taskno,taskname,sname,stagetasks.charpno,NAME,stagetasks.stime, "+
				"stagetasks.etime,stagetasks.budget FROM stagetasks,project,staff,psplan "+
				"WHERE taskno=? AND project.pno=stagetasks.PNo AND staffno=stagetasks.charpno "+
				"AND stagetasks.stageno=psplan.StageNo", new MapHandler(),taskno);
	}
	
	

}
