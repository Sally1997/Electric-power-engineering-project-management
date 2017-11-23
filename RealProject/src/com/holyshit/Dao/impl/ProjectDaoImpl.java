package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.holyshit.Dao.ProjectDao;
import com.holyshit.domain.Project;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;
/**
 * 
 * @author yuan
 *
 */
public class ProjectDaoImpl implements ProjectDao {

	@Override
	public List<Project> selectProjectsById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from psrelation join project where psrelation.pno=project.pno and staffno=? and pstate!='4'",new BeanListHandler<Project>(Project.class),id);
	}

	@Override
	public List<Object> selectProjectStageNoByPN(String pn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT stageno FROM realproject.psplan order by stageno desc;", new ColumnListHandler());
	}

}
