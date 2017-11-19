package com.holyshit.Dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.holyshit.Dao.StageDao;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.C3P0Util;

public class StageDaoImpl implements StageDao {
	public void addStage(ProjectStage pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into ProjectStage"
				+ "values (?,?,?,?,?,?,?)",
				pro_stage.getStageNo(),pro_stage.getProjectNo(),
				pro_stage.getStageName(),pro_stage.getPublisherNo(),
				pro_stage.getChargePerNo(),pro_stage.getStartDate(),
				pro_stage.getEndDate());
		qr.update("insert into taskindexes"
				+ "values (?,?,?,?)",
				task_index.getIndexNo(),task_index.getTaskNo(),
				task_index.getIndexInfo(),task_index.getAttachPath());
	}

}
