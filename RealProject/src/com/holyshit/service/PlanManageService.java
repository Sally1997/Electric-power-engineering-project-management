package com.holyshit.service;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;

public interface PlanManageService {
	public void NewStage(ProjectStage pro_stage,TaskIndexs task_index) throws Exception;
}
