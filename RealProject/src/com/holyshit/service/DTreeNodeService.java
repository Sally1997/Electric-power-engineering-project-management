package com.holyshit.service;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;

public interface DTreeNodeService {
	/**
	 * 查找到项目下所有的阶段ID
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public List<ProjectStage> GetSNByPn(String pn) throws SQLException;
	
	/**
	 * 查找到项目下所有的任务ID
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public List<StageTask> GetTNByPn(String pn) throws SQLException;
	
	/**
	 * 查找到项目下所有项目信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public Project GetProjectInfo(String pn) throws SQLException;
	
	/**
	 * 查找到阶段下所有阶段信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public ProjectStage GetStageInfo(String sn) throws SQLException;
	
	/**
	 * 查找到任务下所有任务信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public StageTask GetTaskInfo(String tn) throws SQLException;
}
