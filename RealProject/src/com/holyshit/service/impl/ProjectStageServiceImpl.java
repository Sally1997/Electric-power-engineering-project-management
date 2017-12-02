package com.holyshit.service.impl;

import com.holyshit.Dao.StageDao;
import com.holyshit.Dao.impl.StageDaoImpl;
import com.holyshit.domain.PsPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;

public class ProjectStageServiceImpl implements ProjectStageSercvice {

	@Override
	public void AddStageandTask(PsPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		StageDao sd = new StageDaoImpl();
		sd.addStage(pro_stage, task_index);
	}

}
