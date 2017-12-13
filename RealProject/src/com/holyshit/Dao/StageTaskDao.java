package com.holyshit.Dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.domain.TaskInfo;
/**
 * 
 * @author yuan
 *
 */
public interface StageTaskDao {
	/**
	 * 查询某个任务已经报销的金额
	 * @param taskno
	 * @return
	 * @throws SQLException
	 */
	BigDecimal selectFeeUsedByTaskno(String taskno) throws SQLException;
	
	/**
	 * 根据id获取员工的所有正在进行的任务
	 * @return 任务列表
	 */
	List<StageTask> selectAllTasksById(String id)throws SQLException;
	
	/***
	 * 根据任务id获取任务的相关信息
	 * @param taskno
	 * @return
	 * @throws SQLException
	 */
	TaskInfo selectTaskInfoByTaskNo(String taskno)throws SQLException;
	
	/**
	 * 获取用户的所有正在进行的任务的相关信息通过员工id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<TaskInfo> selectTaskInfoById(String id)throws SQLException;
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
	void addTask(StageTask stage_task,TaskIndexs task_index) throws SQLException;
	
	/**
	 * 新建指标
	 * @param task_index
	 * @throws SQLException 
	 */
	void insertIndexInfo(TaskIndexs task_index) throws SQLException;
}
