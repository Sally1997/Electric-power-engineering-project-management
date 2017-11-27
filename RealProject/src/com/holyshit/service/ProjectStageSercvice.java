package com.holyshit.service;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;

public interface ProjectStageSercvice {
	public void AddStageandTask(ProjectStage pro_stage, TaskIndexs task_index) throws Exception;
}
