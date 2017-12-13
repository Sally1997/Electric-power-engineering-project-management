package com.holyshit.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.ConnectionManager;

public class PSPlanDaoImpl implements PSPlanDao {

	@Override
	public PSPlan selectPsPlanInfo(String stageno) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return null;
		/*qr.update(ConnectionManager.getConnection(), "insert into PSPlan(stageno,PNo,SName,PubPNo,CharPNo,STime,ETime,SState,budget) "
				+ "values (?,?,?,?,?,?,?,?)",
				pro_stage.getStageno(),pro_stage.getPno(),
				pro_stage.getSname(),
				pro_stage.getCharpno(),pro_stage.getStime(),
				pro_stage.getEtime(),pro_stage.getBudget(),
				pro_stage.getSstate());
		qr.update(ConnectionManager.getConnection(), "insert into taskindexes(IndexNo,TaskNo,IndexInfo,AttachPath,IndexState) "
				+ "values (?,?,?,?,?)",
				task_index.getIndexNo(),task_index.getTaskNo(),
				task_index.getIndexInfo(),task_index.getAttachPath(),
				task_index.getIndexState());*/
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

}
