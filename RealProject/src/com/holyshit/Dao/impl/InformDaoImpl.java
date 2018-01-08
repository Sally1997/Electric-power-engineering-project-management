package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.InformDao;
import com.holyshit.domain.Inform;
import com.holyshit.domain.InformDocument;
import com.holyshit.domain.InformFee;
import com.holyshit.domain.InformProject;
import com.holyshit.domain.InformStageIndex;
import com.holyshit.domain.InformTaskIndex;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
import com.sun.mail.auth.Ntlm;

public class InformDaoImpl implements InformDao {
	public void updatehasread(String mno) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update inform set hasread='1' where mno=?", mno);
	}

	@Override
	public List<Object> selectCurPaauditNO() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT paauditno FROM projaprlaudit ORDER BY paauditno DESC LIMIT 0,1", new ColumnListHandler());
	}

	@Override
	public void insertInform(Inform info) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype) "+
				"VALUES(?,?,?,?)",info.getBusno(),info.getSrcpno(),info.getDstpno(),info.getMtype());
	}
	
	public void insertInformhr(String pno,String type,String staffno,String me) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Timestamp d = new Timestamp(System.currentTimeMillis());
		qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype,hasread,mdate) "+
				"VALUES(?,?,?,?,?,?)",pno,me,staffno,type,"0",d);
	}
	public void insertInformdocaudit(String dno,String type,String staffno,String me) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Timestamp d = new Timestamp(System.currentTimeMillis());
		qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype,hasread,mdate) "+
				"VALUES(?,?,?,?,?,?)",dno,me,staffno,type,"0",d);
	}

	@Override
	public Inform selectInformByMno(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT * FROM inform WHERE mno=?", new BeanHandler<Inform>(Inform.class),mno);
	}

	@Override
	public void updateInformState(String mno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"UPDATE inform SET hasread='1' WHERE mno=?",mno);
	}

	@Override
	public List<InformFee> selectInformByTypeInFee(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,taskname,fee,ofeereason,auditadv FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A0' OR mtype='A1' OR mtype='A2') and hasread='0') a JOIN feeaudit ON a.busno=feeaudit.fauditno JOIN stagetasks ON feeaudit.taskno=stagetasks.TaskNo";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformFee>(InformFee.class));
	}

	@Override
	public long selectInformNumberBytype(String staffno, String type)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select count(*) from inform where hasread='0' and dstpno='"+staffno+"' and mtype like '"+type+"%'";
		
		return (long) qr.query(ConnectionManager.getConnection(), sql, new ScalarHandler());
	}

	@Override
	public List<Object> selectTypeById(String staffno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT DISTINCT mtype  FROM inform WHERE dstpno='"+staffno+"' AND hasread='0'";
		
		return qr.query(ConnectionManager.getConnection(), sql,new ColumnListHandler(1));
	}

	@Override
	public List<InformDocument> selectInformByTypeInDocument(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,dtitle FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A3' OR mtype='A4') and hasread='0') a JOIN document ON a.busno=document.DNo";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformDocument>(InformDocument.class));
	}

	@Override
	public List<InformTaskIndex> selectInformByTypeInTaskIndex(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,taskname,taskno FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A5' OR mtype='A6' OR mtype='A7') and hasread='0') a JOIN stagetasks ON a.busno=stagetasks.taskno";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformTaskIndex>(InformTaskIndex.class));
	}

	@Override
	public List<InformStageIndex> selectInformByTypeInStageIndex(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,sname,stageno FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A8' OR mtype='A9' OR mtype='A10') and hasread='0') a JOIN psplan ON a.busno=psplan.stageno";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformStageIndex>(InformStageIndex.class));
	}

	@Override
	public List<InformProject> selectInformByTypeInProject(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,pname FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A11' OR mtype='A12' OR mtype='A13') and hasread='0') a JOIN project ON a.busno=project.pno";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformProject>(InformProject.class));
	}

	@Override
	public int hasRead(String mno, String flag) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="update inform set hasread=? where mno=?";
		return qr.update(ConnectionManager.getConnection(), sql,flag,mno);
	}

	@Override
	public int insertInform(Inform info, int flag) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype,hasread) "+
				"VALUES(?,?,?,?,?)",info.getBusno(),info.getSrcpno(),info.getDstpno(),info.getMtype(),
				info.getHasread());
	}

	

}
