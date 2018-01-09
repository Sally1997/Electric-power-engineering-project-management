package com.holyshit.service;

import java.util.List;
import java.util.Map;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;

public interface PSPlanService {
	/**
	 * 根据阶段编号获取就欸u但
	 * @param stageno
	 * @return
	 */
	PSPlan getPSPlan(String stageno);
	
	/**
	 * 获取阶段可能改变的任务
	 * @return
	 */
	List<PSPlan> findAllChangeState();
	
	/**
	 * 刷新阶段状态
	 * @param para
	 * @return
	 */
	boolean refreshStageState(Map<String, String> para);
}
