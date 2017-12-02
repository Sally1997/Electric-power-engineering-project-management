package com.holyshit.service;

import com.holyshit.domain.PsPlan;
import com.holyshit.domain.TaskIndexs;

public interface PlanManageService {
	public void NewStage(PsPlan pro_stage,TaskIndexs task_index) throws Exception;
}
