package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
/**
 * 
 * @author yuan
 *
 */
public interface StageTaskDao {
	/**
	 * 根据id获取员工的所有正在进行的任务
	 * @return 任务列表
	 */
	List<StageTask> selectAllTasksById(String id)throws SQLException;
	
	/**
	 * 根据任务编号生成新的指标编号
	 * @param tn
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectIndexNobyTN(String tn) throws SQLException;
	
	/**
	 * 根据阶段编号生成新的任务编号
	 * @param ntn
	 * @return
	 * @throws SQLException
	 */
	List<Object> selectTaskNoby9TN(String ntn) throws SQLException;
	
	/**
	 * 新建任务和任务指标
	 * @param stage_task 阶段任务
	 * @param task_index 任务指标
	 * @throws SQLException 
	 */
	public void addTask(StageTask stage_task,TaskIndexs task_index) throws SQLException;
}
