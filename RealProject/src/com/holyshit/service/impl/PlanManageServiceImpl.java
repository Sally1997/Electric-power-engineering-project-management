package com.holyshit.service.impl;

import com.holyshit.Dao.PsPlanDao;
import com.holyshit.Dao.impl.PsPlanDaoImpl;
import com.holyshit.domain.PsPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.PlanManageService;

public class PlanManageServiceImpl implements PlanManageService {
	//调用dao层
	PsPlanDao stagedao =  new PsPlanDaoImpl();
	
	@Override
	public void NewStage(PsPlan pro_stage, TaskIndexs task_index) throws Exception {
		// TODO Auto-generated method stub
		stagedao.addStage(pro_stage, task_index);
	}

}
