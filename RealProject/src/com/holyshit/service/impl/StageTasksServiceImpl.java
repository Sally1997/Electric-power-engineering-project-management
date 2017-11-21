package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.StageTasksDao;
import com.holyshit.Dao.impl.StageTasksDaoImpl;
import com.holyshit.domain.StageTask;
import com.holyshit.service.StageTasksService;
import com.holyshit.utils.ConnectionManager;

public class StageTasksServiceImpl implements StageTasksService{

	@Override
	public List<StageTask> findAllTasksByid(String id) {
		// TODO Auto-generated method stub
		List<StageTask> tasks=null;
		StageTasksDao std=new StageTasksDaoImpl();
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

}
