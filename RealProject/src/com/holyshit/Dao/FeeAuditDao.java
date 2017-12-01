package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.ProjectStageBudget;

public interface FeeAuditDao {
	/**
	 * 通过项目id查询视图里相应的阶段预算
	 * @param id 项目编号
	 * @return
	 */
	List<ProjectStageBudget> selectProjectStageBudget(String id) throws SQLException;
}
