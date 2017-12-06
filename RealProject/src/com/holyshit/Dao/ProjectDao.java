package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectInfo;
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
	/**
	 * 根据id查询项目
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Project selectProjetById(String id)throws SQLException;
	
	/**
	 * 新建项目
	 * @param pro
	 * @throws SQLException 
	 */
	public void addProject(Project pro) throws SQLException;
	
	/**
	 * 根据项目编号第一位，即项目类型，获取降序排列后的项目编号第一位
	 * @param pro_first_no
	 * @return
	 * @throws SQLException 
	 */
	List<Object> getMaxProNo(String pro_first_no) throws SQLException;
	
	/**
	 * 搜索
	 * @return
	 * @throws SQLException 
	 */
	List<ProjectInfo> selectProjectManageInfo(int current_page,int page_size) throws SQLException;
	
	/**
	 * 查询项目管理首页的页数
	 * @return
	 * @throws SQLException 
	 */
	public int PMPageCount() throws SQLException;
}  



