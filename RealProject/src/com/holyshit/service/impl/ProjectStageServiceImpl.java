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
import com.holyshit.service.ProjectStageSercvice;

public class ProjectStageServiceImpl implements ProjectStageSercvice {

	@Override
<<<<<<< HEAD
	public void AddStageandTask(PsPlan pro_stage, TaskIndexs task_index) throws Exception {
=======
	public void AddStageandTask(PSPlan pro_stage, TaskIndexs task_index) throws Exception {
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
		// TODO Auto-generated method stub
<<<<<<< HEAD
		PsPlanDao sd = new PsPlanDaoImpl();
=======
		PSPlanDao sd = new StageDaoImpl();
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
		sd.addStage(pro_stage, task_index);
	}

}
