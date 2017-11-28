package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.holyshit.Dao.StageTasksDao;
import com.holyshit.domain.DTree;
import com.holyshit.domain.StageTask;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
/**
 * 
 * @author yuan
 *
 */
public class StageTasksDaoImpl implements StageTasksDao {

	@Override
	public List<StageTask> selectAllTasksById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from stagetasks where charpno=? and tstate!='2'",new BeanListHandler<StageTask>(StageTask.class),id);
	}

	@Override
	public List<Object> selectIndexNobyTN(String tn) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT IndexNo FROM taskindexes where IndexNo like ? order by indexno desc", new ColumnListHandler(), tn+"%");
	}

}
