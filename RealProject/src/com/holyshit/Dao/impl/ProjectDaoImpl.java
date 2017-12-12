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
import com.holyshit.domain.ProjectInfo;
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
		return qr.query(ConnectionManager.getConnection(),"select * from psrelation join project where psrelation.pno=project.pno and staffno=? and (pstate='1' or pstate='2')",new BeanListHandler<Project>(Project.class),id);
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
		return (Long) qr.query(ConnectionManager.getConnection(),"SELECT COUNT(*) FROM psrelation ps JOIN project pr ON ps.PNo=pr.PNo WHERE staffno=? AND (pstate='1' OR pstate='2')",new ScalarHandler(),id);
	}

	@Override
	public List<Project> showPage(int cur, int pagesize,String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"SELECT * FROM psrelation JOIN project WHERE psrelation.pno=project.pno AND staffno=? AND (pstate='1' OR pstate='2') LIMIT ?,?",new BeanListHandler<Project>(Project.class),id,(cur-1)*pagesize,pagesize);
	}

	@Override
	public Project selectProjetById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		return qr.query(ConnectionManager.getConnection(), "select * from project where pno=?", new BeanHandler<Project>(Project.class),id);
		
	}

	@Override
	public void addProject(Project pro) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO project(Pno,PMNo,PName,PType,PBudget,PStage,PState,STime,Etime) "
				+"VALUES(?,?,?,?,?,?,?,?,?)",pro.getPno(),
				pro.getPmno(),pro.getPname(),
				pro.getPtype(),pro.getPbudget(),
				pro.getPstage(),pro.getPstate(),
				pro.getStime(),pro.getEtime());
	}

	@Override
	public List<Object> getMaxProNo(String pro_first_no) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT PNo FROM Project WHERE Pno LIKE ? ORDER BY Pno DESC",
				new ColumnListHandler(),pro_first_no+"%");
	}

	@Override
	public List<ProjectInfo> selectProjectManageInfo(String staffno,int current_page,int page_size) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT Project.Pno,PName,NAME,duty,PType,PState "+
				"FROM project,psrelation,staff WHERE project.PNo=psrelation.PNo "+
				"AND PMno=staff.staffno AND psrelation.staffno=? "+
				"LIMIT ?,?",new BeanListHandler<ProjectInfo>(ProjectInfo.class),
				staffno,(current_page-1)*page_size,page_size);
	}

	@Override
	public int PMPageCount() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		long l = (long) qr.query("select count(*) from ("+
				"SELECT Project.Pno,PName,NAME,duty,PType,PState "+
				"FROM project,psrelation,staff WHERE project.PNo=psrelation.PNo "+
				"AND PMno=staff.staffno AND psrelation.staffno=?)a", new ScalarHandler(1));
		return (int)l;
	}

	@Override
	public int selectCountStage(String pno) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		long l = (long) qr.query("SELECT stageno FROM psplan WHERE pno=?", 
				new ScalarHandler(1),pno);
		return (int)l;
	}

}
