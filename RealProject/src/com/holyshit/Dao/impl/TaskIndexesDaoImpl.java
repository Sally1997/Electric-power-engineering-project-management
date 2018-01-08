package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.holyshit.Dao.TaskIndexesDao;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;

public class TaskIndexesDaoImpl implements TaskIndexesDao {

	@Override
	public List<Map<String, Object>> selectTaskIndexes(String taskno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT indexno,indexinfo,AttachPath FROM taskindexes WHERE taskno=?", 
				new MapListHandler(),taskno);
	}

	@Override
	public void updateIndexState(String indexno, String indexstate) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"UPDATE taskindexes SET indexstate=? WHERE indexno=?", 
				indexstate,indexno);
	}

	@Override
	public void insertTaskIndexes(TaskIndexs ti) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(),"INSERT INTO taskindexes(TaskNo,IndexInfo,achReq) "+
				"VALUES(?,?,?)",ti.getTaskno(),ti.getIndexinfo(),ti.getAchreq());
		
		
	}

}
