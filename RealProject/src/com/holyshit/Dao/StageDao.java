package com.holyshit.Dao;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;

public interface StageDao {
	//新建阶段，先添加项目阶段和任务指标
	public void addStage(ProjectStage pro_stage,TaskIndexs task_index) throws Exception;
}
