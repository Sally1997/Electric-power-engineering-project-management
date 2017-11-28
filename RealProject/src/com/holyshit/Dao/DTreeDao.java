package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;

public interface DTreeDao {
	/**
	 * 根据项目编号查找该项目下所有的阶段标号
	 * @return
	 * @throws SQLException 
	 */
	List<ProjectStage> selectAllSNByPn(String pn) throws SQLException;
	
	/**
	 * 根据项目编号查找该项目下所有的任务编号
	 * @return
	 * @throws SQLException 
	 */
	List<StageTask> selectAllTNByPn(String pn) throws SQLException;
	
	/**
	 * 根据项目编号获取整个项目信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	Project selectProjectInfo(String pn) throws SQLException;
}
