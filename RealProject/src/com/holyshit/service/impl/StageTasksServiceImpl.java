package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.StageTaskDao;
import com.holyshit.Dao.impl.StageTaskDaoImpl;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.StageTasksService;
import com.holyshit.utils.ConnectionManager;

public class StageTasksServiceImpl implements StageTasksService{

	@Override
	public List<StageTask> findAllTasksByid(String id) {
		// TODO Auto-generated method stub
		List<StageTask> tasks=null;
		StageTaskDao std=new StageTaskDaoImpl();
		try {
			tasks=std.selectAllTasksById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		
		return tasks;
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

}
