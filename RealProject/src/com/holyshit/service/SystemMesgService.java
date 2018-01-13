package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.TaskMesg;

public interface SystemMesgService {
	List<TaskMesg> findAllSystemMesg(String me);
}
