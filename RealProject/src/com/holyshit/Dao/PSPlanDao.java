package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.PSPlan;

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
}
