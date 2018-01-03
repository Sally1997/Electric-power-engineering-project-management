package com.holyshit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Document;
import com.holyshit.domain.Inform;
import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Projaprlaudit;
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
	List<Object> getNewStageNo(String pn);
	
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
	Map<String,Object> getProjectManageInfo(String staffno,int current_page,int page_size);
	
	/**
	 * 判断项目是否为空
	 * @param pno
	 * @return
	 */
	boolean ifIsEmptyProject(String pno);
	
	/**
	 * 分页显示正在进行的项目信息
	 * @param staffno
	 * @param cur
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> showProjectInfoByPage(String staffno,int cur,int pageSize);
	
	/**
	 * 新建项目时候的处理
	 * @param pro 项目信息
	 * @param paa 立项审核信息
	 * @param info 消息
	 * @param doc 文档
	 * @param pda 立项文档
	 * @return
	 */
	boolean newPeojectManage(Project pro,PSRelation psr,Inform info,Document doc,PDocAudit pda);
}
