package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.DocumentDao;
import com.holyshit.domain.Document;
import com.holyshit.utils.ConnectionManager;

public class DocumentDaoImpl implements DocumentDao{

	@Override
	public List<Document> selectAllDocumentByUserId(String id)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),
				"",
				new BeanListHandler<Document>(Document.class),
				id);
	}

}
