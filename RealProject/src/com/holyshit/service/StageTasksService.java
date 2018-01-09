package com.holyshit.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Inform;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.domain.TaskInfo;

public interface StageTasksService {
	/**
	 * 根据员工id，获取员工正在进行的所有任务
	 * @param id 员工id
	 * @return
	 */
	Map<String, Object> findAllTasksByid(String id);
	
	/**
	 * 根据任务编号对已有的（空的）指标编号排序后返回
	 * @param tn
	 * @return
	 * @throws SQLException 
	 */
	List<Object> getNewIndexNo(String tn) throws SQLException;
	
	public void AddTaskandIndex(StageTask stage_task,TaskIndexs task_index) throws SQLException;
	
	/**
	 * 根据阶段编号对已有的（空的）任务编号排序后返回
	 * @param tn
	 * @return
	 * @throws SQLException 
	 */
	List<Object> getNewTaskNo9(String ntn) throws SQLException;
	
	/**
	 * 查询某个任务的具体信息
	 * @param taskno
	 * @return
	 */
	TaskInfo findTaskInfoById(String taskno);
	
	/**
	 * 查询某个任务已报账金额
	 * @param taskno
	 * @return
	 */
	double findUsedFeeByTaskno(String taskno);
	
	/**
	 * 插入指标信息
	 * @param task_index
	 */
	public void addIndexInfo(TaskIndexs task_index);
	
	/**
	 * 添加一个心得阶段
	 * @param stage_task
	 */
	public void addTask(StageTask stage_task);
	
	/**
	 * 分页查询任务的信息
	 * @param staffno
	 * @param cur
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> showTaskInfoByPage(String staffno,int cur,int pageSize);
	
	/**
	 * 获取任务信息
	 * @param taskno
	 * @return
	 */
	StageTask getStageTask(String taskno);
	
	/**
	 * 添加一个新阶段
	 * @param pno
	 * @param parray
	 * @param icArray
	 * @param anArray
	 * @param iArray
	 * @param prArray
	 */
	void addTaskAndIndex(String ptn,String pno,StageTask[] parray, String[] icArray,String[] anArray,Inform[] iArray,PSRelation[] prArray);
	
	/**
	 * 获取状态可能改变的任务
	 * @return
	 */
	List<StageTask> findAllChangeState();
	
	/**
	 * 刷新任务状态
	 * @param para
	 * @return
	 */
	boolean refreshTaskState(Map<String, String> para);
}
