package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.Inform;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.PSRelation;
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
	
	/**
	 * 根据pno获取最新的阶段编号
	 * @param pno
	 * @return
	 */
	public List<Object> getLatestStageNo(String pno);
	
	/**
	 * 添加阶段和阶段指标，给负责人发消息以及负责人与项目组的关系
	 * @param parray
	 * @param icArray
	 * @param anArray
	 */
	public void addStageAndIndex(String pno,PSPlan[] parray,String[] icArray,
			String[] anArray,Inform[] iArray,PSRelation[] prArray);
}
