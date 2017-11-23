package com.holyshit.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.Dao.ProjectDao;
import com.holyshit.Dao.impl.ProjectDaoImpl;
import com.holyshit.domain.Project;
import com.holyshit.service.ProjectService;
import com.holyshit.utils.ConnectionManager;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<Project> findAllProjectsById(String id) {
		// TODO Auto-generated method stub
		List<Project> projects=null;
		ProjectDao pd=new ProjectDaoImpl();
		try {
			projects=pd.selectProjectsById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		System.out.println(projects);
		return projects;
	}

	@Override
	public List<Object> getNewStageNo(String pn) throws SQLException {
		ProjectDao pjd = new ProjectDaoImpl();
		return pjd.selectProjectStageNoByPN(pn);
	}

}
