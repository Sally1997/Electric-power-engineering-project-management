package com.holyshit.Dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.holyshit.Dao.DTreeDao;
import com.holyshit.domain.Project;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.utils.C3P0Util;

public class DTreeDaoImpl implements DTreeDao {

	@Override
	public List<PSPlan> selectAllSNByPn(String pn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psplan "
				+"where stageno like ?", new BeanListHandler<PSPlan>(PSPlan.class)
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
	public PSPlan selectStageInfo(String sn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from psplan where stageNo = ?",
				new BeanHandler<PSPlan>(PSPlan.class), sn);
	}

	@Override
	public StageTask selectTaskInfo(String tn) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from stagetasks where taskno = ?",
				new BeanHandler<StageTask>(StageTask.class), tn);
	}

	@Override
	public List<Map<String, Object>> selectTreeAttribute(String pn) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT PNo AS id,PName AS name,0 AS pid "+
			"FROM project WHERE pno =? "+
			"UNION SELECT stageNo AS id,Sname AS name,pno AS pid "+ 
			"FROM psplan where stageno LIKE ?"+
			"UNION SELECT TaskNo AS id,TaskName AS name,ptaskno AS pid "+
			"FROM stagetasks WHERE taskno LIKE ?",
			new MapListHandler(),pn,pn+"%",pn+"%");
	}

	@Override
	public Map<String, Object> selectNodeInfo(String no) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT * FROM("+
					"SELECT stagetasks.taskno AS no,taskname AS name,staff.Name AS charpname,stime,etime,budget "+
					"FROM staff,stagetasks WHERE staffno=charpno UNION "+
					"SELECT stageno AS NO,sname AS NAME,staff.Name AS charpname,stime,etime,budget "+
					"FROM staff,psplan WHERE staffno=charpno UNION "+
					"SELECT pno AS NO,pname AS NAME,staff.Name AS charpname,stime,etime,pbudget AS budget "+
					"FROM staff,project WHERE staffno=pmno)a "+
					"WHERE a.no=?",
				new MapHandler(), no);
	}

	@Override
	public List<Object> selectIndexInfo(String no) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT indexinfo FROM taskindexes "+
					"WHERE taskno=?", new ColumnListHandler(),no);
	}

}
