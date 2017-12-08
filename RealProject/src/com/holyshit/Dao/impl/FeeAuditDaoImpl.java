package com.holyshit.Dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.FeeAuditDao;
import com.holyshit.domain.FeeAudit;
import com.holyshit.domain.ProjectStageBudget;
import com.holyshit.utils.ConnectionManager;

public class FeeAuditDaoImpl implements FeeAuditDao{

	@Override
	public List<ProjectStageBudget> selectProjectStageBudget(String id)throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from projectstagebudget where pno=? order by stageno",new BeanListHandler<ProjectStageBudget>(ProjectStageBudget.class),id);
//		return null;
	}

	@Override
	public List<FeeAudit> selectAllFeeInfoPageById(int cur, int pageSize,
			String staffno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from feeaudit where applicantno=? order by stime desc limit ?,?",new BeanListHandler<FeeAudit>(FeeAudit.class),staffno,(cur-1)*pageSize,pageSize );
	}

	@Override
	public long selectTotalNumById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (Long)qr.query(ConnectionManager.getConnection(),"select count(*) from feeaudit where applicantno=?",new ScalarHandler(),id);
	}

	@Override
	public int addFeeAudit(String taskno,double fee,String applicantno,String auditor,String pno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "INSERT INTO feeaudit(applicantno,auditorno,pno,auditstate,fee,taskno,stime) VALUES(?,?,?,'0',?,?,?)",applicantno,auditor,pno,fee,taskno,new Date(new java.util.Date().getTime()));
	}

	@Override
	public int addFeeAuditOver(String taskno,double fee,String cause,String applicantno,String auditor,String pno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "INSERT INTO feeaudit(applicantno,auditorno,pno,auditstate,fee,taskno,stime,ofeereason) VALUES(?,?,?,'0',?,?,?,?)",applicantno,auditor,pno,fee,taskno,new Date(new java.util.Date().getTime()),cause);
	}

	@Override
	public List<FeeAudit> selectFeeAuditInfoPageById(int cur, int pageSize,
			String staffno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from feeaudit where auditorno=? order by stime desc limit ?,?",new BeanListHandler<FeeAudit>(FeeAudit.class),staffno,(cur-1)*pageSize,pageSize);
	}

	@Override
	public long selectTotalAuditById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (long) qr.query(ConnectionManager.getConnection(),"select count(*) from feeaudit where auditorno=?",new ScalarHandler(),id);
	}

	@Override
	public int updateAudit(String fauditno, String state, String cause)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(),"UPDATE feeaudit SET auditadv=?,audittime=?,auditstate=? WHERE fauditno=?",cause,new Date(new java.util.Date().getTime()),state,fauditno);
	}

}
