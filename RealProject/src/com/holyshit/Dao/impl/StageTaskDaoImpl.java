package com.holyshit.Dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.StageTaskDao;
import com.holyshit.domain.DTree;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.domain.TaskInfo;
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
		return qr.query(ConnectionManager.getConnection(),"select * from stagetasks where charpno=? and (tstate='2' or tstate='1')",new BeanListHandler<StageTask>(StageTask.class),id);
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
		qr.update("INSERT INTO stagetasks(taskno,taskname,stime,etime,ptasktype,charpno,ptaskno,tstate,budget) "
				+"values(?,?,?,?,?,?,?,?,?)", stage_task.getTaskno(),
				stage_task.getTaskname(),stage_task.getStime(),
				stage_task.getEtime(),stage_task.getPtasktype(),
				stage_task.getCharpno(),stage_task.getPtaskno(),
				stage_task.getTstate(),stage_task.getBudget());
		qr.update(ConnectionManager.getConnection(), "insert into taskindexes(IndexNo,TaskNo,IndexInfo,AttachPath,IndexState) "
				+ "values (?,?,?,?,?)",
				task_index.getIndexno(),task_index.getTaskno(),
				task_index.getIndexinfo(),task_index.getAttachpath(),
				task_index.getIndexstate());
	}

	@Override
	public List<Object> selectTaskNoby9TN(String ntn) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT TaskNo FROM StageTasks where TaskNo like ? order by TaskNo desc", new ColumnListHandler(), ntn+"%");
	}

	@Override
	public TaskInfo selectTaskInfoByTaskNo(String taskno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"SELECT project.PName,psplan.SName,stagetasks.TaskName,project.PNo,psplan.StageNo,stagetasks.TaskNo,stagetasks.budget,stagetasks.charpno,stagetasks.ptaskno,stagetasks.ptasktype FROM stagetasks JOIN psplan ON stagetasks.stageno=psplan.StageNo JOIN project ON psplan.PNo=project.PNo WHERE taskno=?",new BeanHandler<TaskInfo>(TaskInfo.class),taskno);
	}

	@Override
	public List<TaskInfo> selectTaskInfoById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"SELECT project.PName,psplan.SName,stagetasks.TaskName,project.PNo,psplan.StageNo,stagetasks.TaskNo,stagetasks.budget,stagetasks.charpno,stagetasks.ptaskno,stagetasks.ptasktype FROM stagetasks JOIN psplan ON  stagetasks.stageno=psplan.StageNo JOIN project ON psplan.PNo=project.PNo WHERE stagetasks.CharPNo=? AND (stagetasks.TState='1' OR stagetasks.TState='2')",new BeanListHandler<TaskInfo>(TaskInfo.class),id);
	}

	@Override
	public BigDecimal selectFeeUsedByTaskno(String taskno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (BigDecimal) qr.query(ConnectionManager.getConnection(), "SELECT SUM(fee) FROM feeaudit WHERE taskno=? AND auditstate='2'",new ScalarHandler(),taskno);
		
	}

	@Override
	public void insertIndexInfo(TaskIndexs task_index) throws SQLException {
		QueryRunner qr=new QueryRunner();
		qr.update(ConnectionManager.getConnection(), 
			"INSERT INTO taskindexes(taskno,indexinfo,indexstate,achreq)"+
					"VALUES(?,?,?,?)",task_index.getTaskno(),
					task_index.getIndexinfo(),task_index.getIndexstate(),
					task_index.getAchreq());
		
	}

	@Override
	public void insertTask(StageTask stage_task) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO stagetasks(taskno,taskname,stime,etime,ptasktype,charpno,ptaskno,tstate,budget,pno,stageno) "
				+"values(?,?,?,?,?,?,?,?,?,?,?)", stage_task.getTaskno(),
				stage_task.getTaskname(),stage_task.getStime(),
				stage_task.getEtime(),stage_task.getPtasktype(),
				stage_task.getCharpno(),stage_task.getPtaskno(),
				stage_task.getTstate(),stage_task.getBudget(),
				stage_task.getPno(),stage_task.getStageno());
	}

	@Override
	public String selectTaskCharge(String taskno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (String) qr.query(ConnectionManager.getConnection(), "select charpno from stagetasks where taskno=?",new ScalarHandler(),taskno);
	}

	@Override
	public List<TaskInfo> selectTaskInfoByPage(String staffno, int cur,
			int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "SELECT stagetasks.taskname,stagetasks.taskname,stagetasks.stime,stagetasks.etime,stagetasks.tstate,stagetasks.taskno,stagetasks.pno,project.pname FROM stagetasks JOIN project ON stagetasks.pno=project.pno WHERE charpno=? AND (tstate='1' OR tstate='2') LIMIT ?,?",new BeanListHandler<TaskInfo>(TaskInfo.class),staffno,(cur-1)*pageSize,pageSize);
	}

	@Override
	public long selectTotalTaskById(String staffno) throws SQLException {
		QueryRunner qr=new QueryRunner();
		return (long) qr.query(ConnectionManager.getConnection(), "SELECT count(*) FROM stagetasks JOIN project ON stagetasks.pno=project.pno WHERE charpno=? AND (tstate='1' OR tstate='2')",new ScalarHandler(),staffno);
	}

	@Override
	public StageTask selectStageTasks(String taskno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from stagetasks where taskno=?", new BeanHandler<StageTask>(StageTask.class),
				taskno);
	}

	@Override
	public List<Object> selectPTaskNo(String tno) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT ptaskno FROM stagetasks WHERE taskno=?", new ColumnListHandler(),
				tno);
	}

	@Override
	public List<Object>  selectTaskChargePerson(String tno) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT charpno FROM stagetasks WHERE taskno=?", new ColumnListHandler(),
				tno);
	}

	@Override
	public List<StageTask> selectAllMaybeChangeTask() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select * from stagetasks where tstate='0' or tstate='1'";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<StageTask>(StageTask.class));
	}

	@Override
	public int[] updateTaskByPara(Map<String, String> para) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Object[][] hehe=new Object[para.size()][];
		int i=0;
		for(Map.Entry<String, String> entry:para.entrySet()){
			hehe[i]=new Object[2];
			hehe[i][1]=entry.getKey();
			hehe[i][0]=entry.getValue();
			i++;
		}
		
		//批处理执行更新任务
		String sql="update stagetasks set tstate=? where taskno=?";
		return qr.batch(ConnectionManager.getConnection(), sql, hehe);
	}

}
