package com.holyshit.service;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;

public interface ProjectStageSercvice {
	/**
	 * 这个就废了把
	 * @param pro_stage
	 * @param task_index
	 * @throws Exception
	 */
	public void AddStageandTask(PSPlan pro_stage, TaskIndexs task_index) throws Exception;
	
	/**
	 * 添加阶段
	 * @param pro_stage
	 */
	public void AddStage(PSPlan pro_stage);
}
