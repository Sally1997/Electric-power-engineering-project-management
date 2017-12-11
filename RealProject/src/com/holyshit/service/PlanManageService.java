package com.holyshit.service;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;

public interface PlanManageService {
	/**
	 * 查询阶段信息
	 * @param stageno
	 * @return
	 */
	PSPlan findPsPlanInfo(String stageno);
}
