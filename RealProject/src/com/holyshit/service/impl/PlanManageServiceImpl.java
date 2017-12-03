package com.holyshit.service.impl;

<<<<<<< HEAD
import com.holyshit.Dao.PsPlanDao;
import com.holyshit.Dao.impl.PsPlanDaoImpl;
import com.holyshit.domain.PsPlan;
=======
import com.holyshit.Dao.PSPlanDao;
import com.holyshit.Dao.impl.StageDaoImpl;
import com.holyshit.domain.PSPlan;
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.PlanManageService;

public class PlanManageServiceImpl implements PlanManageService {
	//调用dao层
<<<<<<< HEAD
	PsPlanDao stagedao =  new PsPlanDaoImpl();
=======
	PSPlanDao stagedao =  new StageDaoImpl();
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
	
	@Override
<<<<<<< HEAD
	public void NewStage(PsPlan pro_stage, TaskIndexs task_index) throws Exception {
=======
	public void NewStage(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
		// TODO Auto-generated method stub
		stagedao.addStage(pro_stage, task_index);
	}

}
