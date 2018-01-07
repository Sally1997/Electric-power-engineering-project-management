package com.holyshit.Dao.impl;

import java.sql.SQLException;
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
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
import com.sun.mail.auth.Ntlm;

public class InformDaoImpl implements InformDao {

	@Override
	public List<Object> selectCurPaauditNO() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT paauditno FROM projaprlaudit ORDER BY paauditno DESC LIMIT 0,1", new ColumnListHandler());
	}

	@Override
	public void insertInform(Inform info) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO inform(busno,srcpno,dstpno,mtype,hasread) "+
				"VALUES(?,?,?,?,?)",info.getBusno(),info.getSrcpno(),info.getDstpno(),info.getMtype(),
				info.getHasread());
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
		String sql="SELECT mno,busno,mdate,mtype,taskname,fee FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A0' OR mtype='A1' OR mtype='A2')) a JOIN feeaudit ON a.busno=feeaudit.fauditno JOIN stagetasks ON feeaudit.taskno=stagetasks.TaskNo";
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
		String sql="SELECT mno,busno,mdate,mtype,dtitle FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A3' OR mtype='A4')) a JOIN document ON a.busno=document.DNo";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformDocument>(InformDocument.class));
	}

	@Override
	public List<InformDocument> selectInformByTypeInTaskIndex(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,dtitle FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A5' OR mtype='A6' OR mtype='A7')) a JOIN document ON a.busno=document.DNo";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformDocument>(InformDocument.class));
	}

	@Override
	public List<InformDocument> selectInformByTypeInStageIndex(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,dtitle FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A8' OR mtype='A9' OR mtype='A10')) a JOIN document ON a.busno=document.DNo";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformDocument>(InformDocument.class));
	}

	@Override
	public List<InformProject> selectInformByTypeInProject(String staffno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT mno,busno,mdate,mtype,pname FROM (SELECT mno,busno,mdate,mtype FROM inform WHERE dstpno='"+staffno+"' AND (mtype='A11' OR mtype='A12' OR mtype='A13')) a JOIN project ON a.busno=project.pno";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<InformProject>(InformProject.class));
	}

	

}
