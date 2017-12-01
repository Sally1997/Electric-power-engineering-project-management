package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;
import com.holyshit.utils.C3P0Util;

public class DTreeDaoImpl implements DTreeDao {

	@Override
	public List<ProjectStage> selectAllSNByPn(String pn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psplan "
				+"where stageno like ?", new BeanListHandler<ProjectStage>(ProjectStage.class)
				, pn+"%");
	}
	
	@Override
	public List<StageTask> selectAllTNByPn(String pn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from stagetasks "
				+"where taskno like ?", new BeanListHandler<StageTask>(StageTask.class)
				, pn+"%");
	}

	@Override
	public Project selectProjectInfo(String pn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from project "
				+"where pno = ?", new BeanHandler<Project>(Project.class)
				, pn);
		
	}

	@Override
	public ProjectStage selectStageInfo(String sn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psplan where stageNo = ?",
				new BeanHandler<ProjectStage>(ProjectStage.class), sn);
	}

	@Override
	public StageTask selectTaskInfo(String tn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from stagetasks where taskno = ?",
				new BeanHandler<StageTask>(StageTask.class), tn);
	}

}
