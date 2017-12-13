package com.holyshit.service.impl;

import java.sql.SQLException;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.utils.ConnectionManager;

public class ProjectStageServiceImpl implements ProjectStageSercvice {

	@Override
	public void AddStageandTask(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		PSPlanDao sd = new PSPlanDaoImpl();
//		sd.addStage(pro_stage, task_index);
	}

	@Override
	public void AddStage(PSPlan pro_stage) {
		// TODO Auto-generated method stub
		PSPlanDao sd = new PSPlanDaoImpl();
		try {
			sd.insertStage(pro_stage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection();
		}
	}

}
