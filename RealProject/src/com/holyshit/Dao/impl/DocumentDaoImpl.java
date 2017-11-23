package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.domain.Document;
import com.holyshit.utils.ConnectionManager;

public class DocumentDaoImpl implements DocumentDao{

	@Override
	public List<Document> selectAllDocumentByUserId(String id,int cur,int pageSize)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		//获取大小
		//
		List<Document> list=qr.query(ConnectionManager.getConnection(),
				"SELECT * FROM psrelation JOIN document ON psrelation.pno=document.pno WHERE staffno=? order by desc limit ?,?",
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

}
