package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.TaskMesg;

public interface TaskMesgService {
	List<TaskMesg> findAllTaskMesg(String me);
}
