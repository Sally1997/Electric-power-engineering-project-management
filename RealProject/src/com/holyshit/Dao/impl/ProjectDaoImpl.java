package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.ProjectDao;
import com.holyshit.domain.Project;
import com.holyshit.utils.ConnectionManager;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public List<Project> selectProjectsById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from psrelation join project where psrelation.pno=project.pno and staffno=?",new BeanListHandler<Project>(Project.class),id);
	}

}
