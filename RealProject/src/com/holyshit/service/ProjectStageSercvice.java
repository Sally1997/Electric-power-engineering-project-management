package com.holyshit.service;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;

public interface ProjectStageSercvice {
	public void AddStageandTask(PSPlan pro_stage, TaskIndexs task_index) throws Exception;
}
