package com.holyshit.Dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.ConnectionManager;

public class PSPlanDaoImpl implements PSPlanDao {
	public void addStage(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		
		qr.update(ConnectionManager.getConnection(), "insert into PSPlan(stageno,PNo,SName,PubPNo,CharPNo,STime,ETime,SState,budget) "
				+ "values (?,?,?,?,?,?,?,?,?)",
				pro_stage.getStageNo(),pro_stage.getPNo(),
				pro_stage.getSName(),pro_stage.getPubNo(),
				pro_stage.getCharPNo(),pro_stage.getSTime(),
				pro_stage.getETime(),pro_stage.getSState(),
				pro_stage.getBudget());
		qr.update(ConnectionManager.getConnection(), "insert into taskindexes(IndexNo,TaskNo,IndexInfo,AttachPath,IndexState) "
				+ "values (?,?,?,?)",
				task_index.getIndexNo(),task_index.getTaskNo(),
				task_index.getIndexInfo(),task_index.getAttachPath(),
				task_index.getIndexState());
	}

}
