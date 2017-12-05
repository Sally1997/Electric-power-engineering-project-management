package com.holyshit.service;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectInfo;

public interface ProjectService {
	/**
	 * 根据用户的id，查找其正在参与的所有项目
	 * @param id 用户id
	 * @return  返回项目列表
	 */
	List<Project> findAllProjectsById(String id);
	
	/**
	 * 将阶段编号降序排列，则第一个阶段编号为最大编号，在这个基础上加一则得到最新编号
	 * @param pn
	 * @return
	 * @throws SQLException
	 */
	List<Object> getNewStageNo(String pn) throws SQLException;
	
	/**
	 * 根据servlet新建一个项目
	 * @param pro
	 */
	public void NewProject(Project pro);
	
	/**
	 * 将项目编号降序排列，则第一个项目编号为最大编号，在这个基础上加一则得到最新编号
	 * @param pn_1
	 * @return
	 * @throws SQLException 
	 */
	List<Object> getNewProjectNo(String pn_1);

	/**
	 * 获得项目展示信息
	 * @return
	 */
	List<ProjectInfo> getProjectInfo();
}
