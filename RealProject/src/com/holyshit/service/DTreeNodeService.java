package com.holyshit.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.Project;
import com.holyshit.domain.StageTask;

public interface DTreeNodeService {
	/**
	 * 查找到项目下所有的阶段ID
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public List<PSPlan> GetSNByPn(String pn);
	
	/**
	 * 查找到项目下所有的任务ID
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public List<StageTask> GetTNByPn(String pn);
	
	/**
	 * 查找到项目下所有项目信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public Project GetProjectInfo(String pn);
	
	/**
	 * 查找到阶段下所有阶段信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public PSPlan GetStageInfo(String sn);
	
	/**
	 * 查找到任务下所有任务信息
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public StageTask GetTaskInfo(String tn);
	
	/**
	 * 查找到树的id，name，pid
	 * @param pn
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> GetTreeInfo(String pn);
	
	/**
	 * 获取到树节点的信息
	 * @param no
	 * @return
	 * @throws ParseException 
	 */
	public Map<String,Object> GetNodeInfo(String no);
	
	/**
	 * 添加指标附件路径
	 * @param path 路径
	 * @param no 阶段或者任务编号
	 * @param indexinfo 指标内容
	 */
	public void addIndexPath(String path,String no,String indexinfo);
	
	/**
	 * 根据阶段编号改变状态
	 * @param sno
	 */
	public void changeSState(String sno);
	
	/**
	 * 根据任务编号改变状态
	 * @param tno
	 */
	public void changeTState(String tno);
}
