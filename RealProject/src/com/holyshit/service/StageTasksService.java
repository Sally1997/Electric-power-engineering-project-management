package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.StageTask;

public interface StageTasksService {
	/**
	 * 根据员工id，获取员工正在进行的所有任务
	 * @param id 员工id
	 * @return
	 */
	List<StageTask> findAllTasksByid(String id);

}
