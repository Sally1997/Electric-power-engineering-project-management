package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.holyshit.Dao.StageTaskDao;
import com.holyshit.domain.DTree;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
/**
 * 
 * @author yuan
 *
 */
public class StageTaskDaoImpl implements StageTaskDao {

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

	@Override
	public void addTask(StageTask stage_task, TaskIndexs task_index) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO stagetasks(taskno,taskname,stime,etime,pubpno,charpno,ptaskno,tstate,budget) "
				+"values(?,?,?,?,?,?,?,?,?)", stage_task.getTaskno(),
				stage_task.getTaskname(),stage_task.getStime(),
				stage_task.getEtime(),stage_task.getPubno(),
				stage_task.getCharpno(),stage_task.getPtaskno(),
				stage_task.getTstate(),stage_task.getBudget());
		qr.update(ConnectionManager.getConnection(), "insert into taskindexes(IndexNo,TaskNo,IndexInfo,AttachPath) "
				+ "values (?,?,?,?,?)",
				task_index.getIndexNo(),task_index.getTaskNo(),
				task_index.getIndexInfo(),task_index.getAttachPath(),
				task_index.getIndexState());
	}

	@Override
	public List<Object> selectTaskNoby9TN(String ntn) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT TaskNo FROM StageTasks where TaskNo like ? order by TaskNo desc", new ColumnListHandler(), ntn+"%");
	}

}
