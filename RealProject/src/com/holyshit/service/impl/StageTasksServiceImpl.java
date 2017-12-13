package com.holyshit.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.domain.TaskInfo;
import com.holyshit.service.StageTasksService;
import com.holyshit.utils.ConnectionManager;

public class StageTasksServiceImpl implements StageTasksService{

	@Override
	public Map<String, Object> findAllTasksByid(String id) {
		// TODO Auto-generated method stub
		List<StageTask> tasks=null;
		ProjectDao pd=new ProjectDaoImpl();
		String pname=null;
		StageTaskDao std=new StageTaskDaoImpl();
		List<String> projectNames=new ArrayList<String>();
		try {
			tasks=std.selectAllTasksById(id);
			for(StageTask st : tasks){
				String pno=st.getTaskno().substring(0, 5);
				System.out.println("取到了"+pno);
				pname = pd.selectProjetById(pno).getPname();
				projectNames.add(pname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		Map<String, Object> res=new HashMap<String, Object>();
		res.put("tasks", tasks);
		res.put("projectNames", projectNames);
		return res;
	}

	@Override
	public List<Object> getNewIndexNo(String tn) throws SQLException {
		StageTaskDao st = new StageTaskDaoImpl();
		return st.selectIndexNobyTN(tn);
	}

	@Override
	public void AddTaskandIndex(StageTask stage_task, TaskIndexs task_index) throws SQLException {
		StageTaskDao std = new StageTaskDaoImpl();
		std.addTask(stage_task, task_index);
	}

	@Override
	public List<Object> getNewTaskNo9(String ntn) throws SQLException {
		StageTaskDao st = new StageTaskDaoImpl();
		return st.selectTaskNoby9TN(ntn);
	}

	@Override
	public TaskInfo findTaskInfoById(String taskno) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			return std.selectTaskInfoByTaskNo(taskno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return null;
	}

	@Override
	public double findUsedFeeByTaskno(String taskno) {
		// TODO Auto-generated method stub
		StageTaskDao std=new StageTaskDaoImpl();
		double res=0;
		try {
			BigDecimal fees = std.selectFeeUsedByTaskno(taskno);
			if(fees==null){
				return res;
			}
			String str=fees.toString();
			res=Double.parseDouble(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return res;
	}

	@Override
	public void addIndexInfo(TaskIndexs task_index) {
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			std.insertIndexInfo(task_index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void addTask(StageTask stage_task) {
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			std.insertTask(stage_task);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

}
