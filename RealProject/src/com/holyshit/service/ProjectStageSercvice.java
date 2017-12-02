package com.holyshit.service;

import com.holyshit.domain.PsPlan;
import com.holyshit.domain.TaskIndexs;

public interface ProjectStageSercvice {
	public void AddStageandTask(PsPlan pro_stage, TaskIndexs task_index) throws Exception;
}
