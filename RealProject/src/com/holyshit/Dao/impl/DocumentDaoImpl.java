package com.holyshit.Dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import net.sf.json.JSONArray;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.domain.Document;
import com.holyshit.domain.DocumentInfo;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
import com.holyshit.utils.FileSuffixConvert;

public class DocumentDaoImpl implements DocumentDao{
	public List<Document> findallneededauditfile() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from document where dtype!='1' and auditres='0' order by uploadtime desc",new BeanListHandler<Document>(Document.class));
	}
	
	public void auditfilepass(String dno) throws SQLException{
		System.out.println("Daoauditfile");
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update document set auditres='2' where dno=?" , dno);
	}
	
	public void auditfilefail(String dno) throws SQLException{
		System.out.println("Daoauditfile2");
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update document set auditres='1' where dno=?" , dno);
	}
	@Override
	public List<Document> selectAllDocumentByUserId(String id,int cur,int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		//获取大小
		//
		List<Document> list=qr.query(ConnectionManager.getConnection(),
				"SELECT * FROM psrelation JOIN document ON psrelation.pno=document.pno WHERE staffno=? order by uploadtime desc limit ?,?",
				new BeanListHandler<Document>(Document.class),
				id,(cur-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public long totalSizeWithId(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (Long)qr.query(ConnectionManager.getConnection(),
				"SELECT COUNT(*) FROM psrelation JOIN document ON psrelation.pno=document.pno WHERE staffno=?",
				new ScalarHandler(),
				id);
	}

	@Override
	public Document getDocumentById(String dno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from document where dno=?", new BeanHandler<Document>(Document.class),dno);
	}

	@Override
	public List<DocumentInfo> selectDocumentByCondition(String ptype,String dtype,
			String dateFrom, String dateTo, String keywords, String ftype,int cur,int pageSize,String staffno
			)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select dno,UloadPNo,DTitle,UploadTime,FType,PName,dloadtimes,ptype,fsize from ";
		
		if(!dtype.equals("")){
			sql+=" document p join project on p.pno=project.pno where p.dtype='"+dtype+"'";
		}else{
			//一个复杂的sql
			sql+="(SELECT project.pno,project.pname,project.ptype,document.dno,document.dtitle,document.UloadPNo,document.UploadTime,document.DloadTimes,document.FType,document.FSize FROM document JOIN project ON document.pno=project.pno WHERE (project.pstate='3' OR project.pstate='4') AND auditres='2' union ";
			sql+="SELECT b.pno,b.pname,b.ptype,document.dno,document.dtitle,document.UloadPNo,document.UploadTime,document.DloadTimes,document.FType,document.FSize FROM (SELECT a.pno,project.pname,project.ptype FROM (SELECT pno FROM psrelation WHERE staffno='"+staffno+"')a JOIN project ON a.pno=project.pno)b JOIN document ON b.pno=document.PNo WHERE document.auditres='2')p";
			sql+=" where p.ptype='"+ptype+"'";
			
		}
		if(!dateTo.equals(""))
			sql+=" and p.uploadtime<='"+dateTo+"'";
		if(!dateFrom.equals(""))
			sql+=" and p.uploadtime>='"+dateFrom+"'";
		if(!keywords.equals(""))
			sql+=" and p.dtitle like '%"+keywords+"%'";
		if(!ftype.equals("")){
			if(!ftype.equals("all")){
				String[] types = ftype.split(":");
				sql+=" and (";
				for(int i=0;i<types.length;i++)
					if(i==0){
						String[] cres = FileSuffixConvert.convert(types[i]);
						sql+="p.ftype='"+cres[0]+"'";
						for(int j=1;j<cres.length;j++)
							sql+=" or p.ftype='"+cres[j]+"'";
					}
					else{
						String[] cres = FileSuffixConvert.convert(types[i]);
						for(int j=0;j<cres.length;j++)
							sql+=" or p.ftype='"+cres[j]+"'";
					}
				sql+=" )";
			}
		}
		sql+=" order by p.dloadtimes desc limit "+(cur-1)*pageSize+","+pageSize;
		return qr.query(ConnectionManager.getConnection(), sql,new BeanListHandler<DocumentInfo>(DocumentInfo.class));
	}

	@Override
	public long totalNumWithCondition(String ptype,String dtype, String dateFrom,
			String dateTo, String keywords, String ftype,String staffno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		boolean flag=false;
		String sql="select count(*) from ";
		
		if(!dtype.equals("")){
			sql+=" document p join project on p.pno=project.pno where p.dtype='"+dtype+"'";
		}else{
			//一个复杂的sql
			sql+="(SELECT project.pno,project.pname,project.ptype,document.dno,document.dtitle,document.UloadPNo,document.UploadTime,document.DloadTimes,document.FType,document.FSize FROM document JOIN project ON document.pno=project.pno WHERE (project.pstate='3' OR project.pstate='4') AND auditres='2' union ";
			sql+="SELECT b.pno,b.pname,b.ptype,document.dno,document.dtitle,document.UloadPNo,document.UploadTime,document.DloadTimes,document.FType,document.FSize FROM (SELECT a.pno,project.pname,project.ptype FROM (SELECT pno FROM psrelation WHERE staffno='"+staffno+"')a JOIN project ON a.pno=project.pno)b JOIN document ON b.pno=document.PNo WHERE document.auditres='2')p";
			sql+=" where p.ptype='"+ptype+"'";
			
		}
		if(!dateTo.equals(""))
			sql+=" and p.uploadtime<='"+dateTo+"'";
		if(!dateFrom.equals(""))
			sql+=" and p.uploadtime>='"+dateFrom+"'";
		if(!keywords.equals(""))
			sql+=" and p.dtitle like '%"+keywords+"%'";
		if(!ftype.equals("")){
			if(!ftype.equals("all")){
				String[] types = ftype.split(":");
				sql+=" and (";
				for(int i=0;i<types.length;i++)
					if(i==0){
						String[] cres = FileSuffixConvert.convert(types[i]);
						sql+="p.ftype='"+cres[0]+"'";
						for(int j=1;j<cres.length;j++)
							sql+=" or p.ftype='"+cres[j]+"'";
					}
					else{
						String[] cres = FileSuffixConvert.convert(types[i]);
						for(int j=0;j<cres.length;j++)
							sql+=" or p.ftype='"+cres[j]+"'";
					}
				sql+=" )";
			}
		}
		return (long) qr.query(ConnectionManager.getConnection(), sql,new ScalarHandler());
	}

	@Override
	public int addReadingNumber(String dno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.update(ConnectionManager.getConnection(), "UPDATE document SET DloadTimes=DloadTimes+1 WHERE dno=?",dno);
	}

	@Override
	public int addDocument(String dno, String uloadpno, String pno,
			String dtitle, String dpath, String ftype, String dtype, int fsize)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="insert into document values(?,?,?,?,?,?,?,?,?,?,?)";
		
		return qr.update(ConnectionManager.getConnection(), sql,dno,uloadpno,pno,dtitle,dpath,new Timestamp(new java.util.Date().getTime()),0,ftype,dtype,fsize,"0");
	}
	
	@Override
	public int insertDocument(Document doc) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return qr.update(ConnectionManager.getConnection(),"insert into document(dno,UloadPNo,pno,dtitle,dpath,UploadTime,DloadTimes,FType,dtype,FSize,auditres) "+
				"values(?,?,?,?,?,?,?,?,?,?,?)",doc.getDno(),doc.getUloadpno(),doc.getPno(),
				doc.getDtitle(),doc.getDpath(),doc.getUploadtime(),doc.getDloadtimes(),doc.getFtype(),
				doc.getDtype(),doc.getFsize(),doc.getAuditres());
	}

	@Override
	public void updatePDocAudit(String adv, String auditstate, String dno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"UPDATE gdocaudit SET auditadv=?,"+
				"audittime=CURRENT_TIMESTAMP,auditstate=? WHERE gdocno=?",adv,auditstate,dno);
	}

	@Override
	public void updateDocAuditState(String agree, String dno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"UPDATE document SET auditres=? WHERE dno=?",
				agree,dno);
	}

}
