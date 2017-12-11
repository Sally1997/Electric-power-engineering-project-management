package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.PSPlan;

public interface PSPlanDao {
	
	/**
	 * 查询阶段的详细信息
	 * @param stageno
	 * @throws SQLException
	 */
	PSPlan selectPsPlanInfo(String stageno) throws SQLException;
}
