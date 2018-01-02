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
import com.holyshit.utils.ConnectionManager;
import com.holyshit.utils.FileSuffixConvert;

public class DocumentDaoImpl implements DocumentDao{

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
			String dateFrom, String dateTo, String keywords, String ftype,int cur,int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select dno,UloadPNo,DTitle,UploadTime,FType,PName,dloadtimes,ptype,fsize from document join project on document.pno=project.pno where ";
		if(!dtype.equals("")){
			sql+=" dtype='"+dtype+"'";
		}else{
			sql+=" ptype='"+ptype+"' and document.pno!='00000'";
			
		}
		if(!dateTo.equals(""))
			sql+=" and uploadtime<='"+dateTo+"'";
		if(!dateFrom.equals(""))
			sql+=" and uploadtime>='"+dateFrom+"'";
		if(!keywords.equals(""))
			sql+=" and dtitle like '%"+keywords+"%'";
		if(!ftype.equals("")){
			if(!ftype.equals("all")){
				String[] types = ftype.split(":");
				sql+=" and (";
				for(int i=0;i<types.length;i++)
					if(i==0){
						String[] cres = FileSuffixConvert.convert(types[i]);
						sql+="ftype='"+cres[0]+"'";
						for(int j=1;j<cres.length;j++)
							sql+=" or ftype='"+cres[j]+"'";
					}
					else{
						String[] cres = FileSuffixConvert.convert(types[i]);
						for(int j=0;j<cres.length;j++)
							sql+=" or ftype='"+cres[j]+"'";
					}
				sql+=" )";
			}
		}
		sql+=" order by dloadtimes desc limit "+(cur-1)*pageSize+","+pageSize;
		return qr.query(ConnectionManager.getConnection(), sql,new BeanListHandler<DocumentInfo>(DocumentInfo.class));
	}

	@Override
	public long totalNumWithCondition(String ptype,String dtype, String dateFrom,
			String dateTo, String keywords, String ftype) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		
		String sql="select count(*) from document join project on document.pno=project.pno where";
		if(!dtype.equals("")){
			sql+=" dtype='"+dtype+"'";
		}else{
			sql+=" ptype='"+ptype+"' and document.pno!='00000'";
			
		}
		if(!dateFrom.equals(""))
			sql+=" and uploadtime>='"+dateFrom+"'";
		if(!keywords.equals(""))
			sql+=" and dtitle like '%"+keywords+"%'";
		if(!ftype.equals("")){
			if(!ftype.equals("all")){
				String[] types = ftype.split(":");
				sql+=" and (";
				for(int i=0;i<types.length;i++)
					if(i==0){
						String[] cres = FileSuffixConvert.convert(types[i]);
						sql+="ftype='"+cres[0]+"'";
						for(int j=1;j<cres.length;j++)
							sql+=" or ftype='"+cres[j]+"'";
					}
					else{
						String[] cres = FileSuffixConvert.convert(types[i]);
						for(int j=0;j<cres.length;j++)
							sql+=" or ftype='"+cres[j]+"'";
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

}
