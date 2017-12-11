package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Project;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;

public interface DTreeDao {
	/**
	 * 根据项目编号查找该项目下所有的阶段标号
	 * @return
	 * @throws SQLException 
	 */

	List<PSPlan> selectAllSNByPn(String pn) throws SQLException;
	
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
	
	/**
	 * 根据阶段编号获取整个阶段信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	PSPlan selectStageInfo(String sn) throws SQLException;
	
	/**
	 * 根据任务编号获取整个任务信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	StageTask selectTaskInfo(String tn) throws SQLException;
	/**
	 * 根据项目编号，获取tree说需要的id，name，pid
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectTreeAttribute(String pn) throws SQLException;
	
	/**
	 * 获取节点信息
	 * @throws SQLException 
	 */
	Map<String,Object> selectNodeInfo(String no) throws SQLException;
	
	/**
	 * 获取指标信息
	 * @param no
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectIndexInfo(String no) throws SQLException;
}
