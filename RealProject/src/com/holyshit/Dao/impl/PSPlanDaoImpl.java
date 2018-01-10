package com.holyshit.Dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.C3P0Util;
import com.holyshit.utils.ConnectionManager;

public class PSPlanDaoImpl implements PSPlanDao {

	@Override
	public PSPlan selectPsPlanInfo(String stageno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return qr.query(ConnectionManager.getConnection(),"select * from psplan where stageno=?",new BeanHandler<PSPlan>(PSPlan.class),stageno);
	}

	@Override
	public void insertStage(PSPlan pro_stage) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ConnectionManager.getConnection(), "insert into PSPlan(stageno,PNo,SName,CharPNo,STime,ETime,budget,SState) "
				+ "values (?,?,?,?,?,?,?,?)",
				pro_stage.getStageno(),pro_stage.getPno(),
				pro_stage.getSname(),
				pro_stage.getCharpno(),pro_stage.getStime(),
				pro_stage.getEtime(),pro_stage.getBudget(),
				pro_stage.getSstate());
	}

	@Override
	public List<Object> selectPMNo(String sno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT pmno FROM psplan,project WHERE stageno=? AND psplan.PNo=project.pno", 
				new ColumnListHandler(),sno);
		
	}

	@Override
	public List<Object> selectStageChargePerson(String sno) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("SELECT charpno FROM psplan WHERE stageno=?", new ColumnListHandler(),
				sno);
	}

	@Override
	public List<PSPlan> selectAllMaybeChangeStage() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="select * from psplan where sstate='0' or sstate='1'";
		return qr.query(ConnectionManager.getConnection(), sql, new BeanListHandler<PSPlan>(PSPlan.class));
	}

	@Override
	public int[] updateStageByPara(Map<String, String> para)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		Object[][] hehe=new Object[para.size()][];
		int i=0;
		for(Map.Entry<String, String> entry:para.entrySet()){
			hehe[i]=new Object[2];
			hehe[i][1]=entry.getKey();
			hehe[i][0]=entry.getValue();
			i++;
		}
		
		//批处理执行更新任务
		String sql="update psplan set sstate=? where stageno=?";
		return qr.batch(ConnectionManager.getConnection(), sql, hehe);
	}

	@Override
	public void updateCharP(String sno, String charpno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		System.out.println(charpno);
		System.out.println(sno);
		qr.update(ConnectionManager.getConnection(),"UPDATE psplan SET charpno=? WHERE stageno=?",
				charpno,sno);
	}

	@Override
	public BigDecimal selectStageHasBudget(String stageno)
			throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner();
		String sql="SELECT SUM(stagetasks.budget) FROM (SELECT * FROM psplan WHERE StageNo=?) a JOIN stagetasks ON a.stageno=stagetasks.PTaskNo";
		return (BigDecimal) qr.query(ConnectionManager.getConnection(),sql,new ScalarHandler(),stageno);
	}

}
