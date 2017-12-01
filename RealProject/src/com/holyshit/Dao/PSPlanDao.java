package com.holyshit.Dao;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;

public interface PSPlanDao {
	//新建阶段，先添加项目阶段和任务指标
	public void addStage(PSPlan pro_stage,TaskIndexs task_index) throws Exception;
}
