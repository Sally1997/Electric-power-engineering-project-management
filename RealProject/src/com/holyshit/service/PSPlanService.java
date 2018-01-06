package com.holyshit.service;

import com.holyshit.domain.PSPlan;

public interface PSPlanService {
	/**
	 * 根据阶段编号获取就欸u但
	 * @param stageno
	 * @return
	 */
	PSPlan getPSPlan(String stageno);
}
