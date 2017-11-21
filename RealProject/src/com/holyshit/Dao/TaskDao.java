package com.holyshit.Dao;

import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;

public interface TaskDao {
	public void addStage(StageTask sta_task,TaskIndexs task_index) throws Exception;
}
