package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
/**
 * 
 * @author yuan
 *
 */
public interface ProjectDao {
	//根据项目ID获取整个项目的DAO和SERVICE写在DTREEDAO和DTREENODE里面
	//get all paoject info by id impl in Dtree(in case wrong encording)
	//	^	Look at there
	//	|	My son
	//	|	Dog Yuan
	//get task info and stage info --> DTreeDao
	
	/**
	 * 获取用户正在参与的所有项目的列表
	 * @param id 用户id
	 * @return
	 * @throws SQLException sql异常抛出，service处理
	 */
	List<Project> selectProjectsById(String id)throws SQLException;
	
	/**
	 * 通过获取整个项目阶段编号来初始化新的项目阶段
	 * @param pn 项目编号
	 * @return
	 * @throws SQLException
	 */
	List<Object> selectProjectStageNoByPN(String pn) throws SQLException;
	/**
	 * 查询用户正在参与项目的数量
	 * @param id  用户id
	 * @return
	 * @throws SQLException
	 */
	long selectWorkingProjectNumberById(String id) throws SQLException;
	/**
	 * 显示当前页的项目的信息
	 * @param cur  当前页面
	 * @param pagesize  页面大小
	 * @param staffno  员工编号
	 * @return
	 * @throws SQLException
	 */
	List<Project> showPage(int cur,int pagesize,String staffno) throws SQLException;
	
} 



