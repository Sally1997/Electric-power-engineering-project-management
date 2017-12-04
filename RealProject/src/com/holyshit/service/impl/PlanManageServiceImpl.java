package com.holyshit.service.impl;

import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.PSPlanDaoImpl;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.PlanManageService;

public class PlanManageServiceImpl implements PlanManageService {
	//调用dao层
	PSPlanDao stagedao =  new PSPlanDaoImpl();
	
	@Override
	public void NewStage(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		stagedao.addStage(pro_stage, task_index);
	}

}
