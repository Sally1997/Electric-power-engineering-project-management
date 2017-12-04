package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.FeeAudit;
import com.holyshit.domain.ProjectStageBudget;

public interface FeeAuditDao {
	/**
	 * 通过项目id查询视图里相应的阶段预算
	 * @param id 项目编号
	 * @return
	 */
	List<ProjectStageBudget> selectProjectStageBudget(String id) throws SQLException;
	/**
	 * 根据用户id分页查询报账的详细信息
	 * @param cur
	 * @param pageSize
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<FeeAudit> selectAllFeeInfoPageById(int cur,int pageSize,String staffno)throws SQLException;
	/**
	 * 根据用户id查询相应用户的所有的报账信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	long selectTotalNumById(String id)throws SQLException;
}
