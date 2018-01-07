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
	 * 获取审核信息分页
	 * @param cur
	 * @param pageSize
	 * @param staffno
	 * @return
	 * @throws SQLException
	 */
	List<FeeAudit> selectFeeAuditInfoPageById(int cur,int pageSize,String staffno) throws SQLException;
	
	/**
	 * 查询某人的审核信息总数
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	long selectTotalAuditById(String id)throws SQLException;
	/**
	 * 根据用户id查询相应用户的所有的报账信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	long selectTotalNumById(String id)throws SQLException;
	
	/**
	 * 添加未超标报账信息
	 * @param taskno
	 * @param fee
	 * @return
	 * @throws SQLException
	 */
	int addFeeAudit(String taskno,double fee,String applicantno,String auditor,String pno)throws SQLException;
	
	/**
	 * 添加以超标报账信息
	 * @param taskno
	 * @param fee
	 * @param cause
	 * @return
	 * @throws SQLException
	 */
	int addFeeAuditOver(String taskno,double fee,String cause,String applicantno,String auditor,String pno)throws SQLException;
	
	/**
	 * 任务发布人审核报账信息
	 * @param taskno
	 * @param state
	 * @param cause
	 * @return
	 * @throws SQLException
	 */
	int updateAudit(String fauditno,String state,String cause)throws SQLException;
	
	/**
	 * 根据id获取报账信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	FeeAudit selectFeeAuditInfoById(String id)throws SQLException;
	
	/**
	 * 根据任务编号查询最近一次的报账信息
	 * @param taskno
	 * @return
	 * @throws SQLException
	 */
	FeeAudit selectLastFeeAuditByTaskNo(String taskno)throws SQLException;
}
