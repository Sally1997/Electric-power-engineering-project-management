package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectInfo;
import com.holyshit.domain.StageTask;
/**
 * 
 * @author yuan
 *
 */
public interface ProjectDao {
	
	/**
	 * 查询某人的职责
	 * @param staffno
	 * @param pno
	 * @return
	 * @throws SQLException
	 */
	String selectDuty(String staffno,String pno)throws SQLException;
	
	
	/**
	 * 获取项目的已经报账金额
	 * @param pno
	 * @return
	 * @throws SQLException
	 */
	double selectProjectHasFee(String pno)throws SQLException;
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
	List<ProjectInfo> selectProjectManageInfo(String staffno,int current_page,int page_size) throws SQLException;
	
	/**
	 * 查询项目管理首页的页数
	 * @return
	 * @throws SQLException 
	 */
	public int PMPageCount(String staffno) throws SQLException;
	
	/**
	 * 根据项目编号查找到这个项目下是否有任务
	 * @param pno
	 * @return
	 * @throws SQLException 
	 */
	public int selectCountStage(String pno) throws SQLException;
	
	/**
	 * 改变项目状态
	 * @param pno
	 * @param state
	 * @throws SQLException 
	 */
	public void updateProjectState(String pno,String state) throws SQLException;
	
	/**
	 * 搜索项目信息
	 * @param pno
	 * @return
	 * @throws SQLException 
	 */
	public Project selectProject(String pno) throws SQLException;
	
	/**
	 * 获取所有的状态可能发生改变的项目
	 * @return
	 * @throws SQLException
	 */
	public List<Project> selectAllMaybeChangeProject() throws SQLException;
	
	/**
	 * 更新项目状态
	 * @param para
	 * @return
	 * @throws SQLException
	 */
	int[] updateProjectByPara(Map<String, String> para)throws SQLException;
}  



