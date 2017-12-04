package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.DTreeDao;
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
		return qr.query(ConnectionManager.getConnection(),"select * from psrelation join project where psrelation.pno=project.pno and staffno=? and (pstate='正常进行中' or pstate='延期进行中')",new BeanListHandler<Project>(Project.class),id);
	}

	@Override
	public List<Object> selectProjectStageNoByPN(String pn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT stageno FROM psplan where stageno like ? order by stageno desc;", new ColumnListHandler(),pn+"%");
	}

	@Override
	public long selectWorkingProjectNumberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return (Long) qr.query(ConnectionManager.getConnection(),"SELECT COUNT(*) FROM psrelation ps JOIN project pr ON ps.PNo=pr.PNo WHERE staffno=? AND (pstate='正常进行中' OR pstate='延期进行中')",new ScalarHandler(),id);
	}

	@Override
	public List<Project> showPage(int cur, int pagesize,String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"SELECT * FROM psrelation JOIN project WHERE psrelation.pno=project.pno AND staffno=? AND (pstate='正常进行中' OR pstate='延期进行中') LIMIT ?,?",new BeanListHandler<Project>(Project.class),id,(cur-1)*pagesize,pagesize);
	}

	@Override
	public Project selectProjetById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from project where pno=?", new BeanHandler<Project>(Project.class),id);
		
	}

}
