package com.holyshit.Dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;

public interface PSPlanDao {
	
	/**
	 * author 袁奇中
	 * 查询阶段的详细信息
	 * @param stageno
	 * @throws SQLException
	 */
	PSPlan selectPsPlanInfo(String stageno) throws SQLException;
	
	/**
	 * 插入新的阶段
	 * @param pro_stage
	 * @throws SQLException 
	 */
	void insertStage(PSPlan pro_stage) throws SQLException;
	
	/**
	 * 查找到阶段的负责人也就是项目经理
	 * @param sno
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectPMNo(String sno) throws SQLException;
	
	/**
	 * 查阶段负责人
	 * @param sno
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectStageChargePerson(String sno) throws SQLException;
	
	/**
	 * 获取所有的可能发生改变的阶段
	 * @return
	 * @throws SQLException
	 */
	List<PSPlan> selectAllMaybeChangeStage() throws SQLException;
	
	/**
	 * 更新阶段的状态
	 * @param para
	 * @return
	 * @throws SQLException
	 */
	int[] updateStageByPara(Map<String, String> para)throws SQLException;
	
	/**
	 * 修改负责人
	 * @param sno
	 * @param charpno
	 * @throws SQLException 
	 */
	public void updateCharP(String sno,String charpno) throws SQLException;
	
	/**
	 * 查询阶段已使用预算信息
	 * @param stageno
	 * @return
	 * @throws SQLException
	 */
	BigDecimal selectStageHasBudget(String stageno)throws SQLException;
	
	/**
	 * 改变阶段状态
	 * @param tno
	 * @param tstate
	 * @return
	 * @throws SQLException 
	 */
	int updateStageState(String sno,String sstate) throws SQLException;
}
