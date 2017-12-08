package com.holyshit.service;

import java.util.Map;

import com.holyshit.domain.TaskInfo;

import net.sf.json.JSONArray;

public interface MoneyManageService {
	/**
	 * 分页显示报账审核信息，json传递数据
	 * @param cur
	 * @param pagesize
	 * @param id
	 * @return
	 */
	String showAuditInfoPageById(int cur,int pagesize,String id);
	/***
	 * 分页显示项目资金情况
	 * @param cur 当前页
	 * @param pagesize 页大小
	 * @param id  用户id
	 * @return
	 */
	Map<String, Object> showProjectMoneyPage(int cur,int pagesize,String id);
	/**
	 * 分页显示最近所有项目的报账情况
	 * @param cur
	 * @param pagesize
	 * @param id
	 * @return
	 */
	Map<String, Object> showFeeAuditInfoPage(int cur,int pagesize,String id);
	
	/**
	 * 查找可以报账的任务信息
	 * @param id
	 * @return
	 */
	String findFeeAbledTask(String id);

	/**
	 * 报账
	 * @param task
	 * @param fee
	 * @param cause
	 * @param over
	 * @return
	 */
	int handleFee(TaskInfo task,double fee,String cause,boolean over);
	/**
	 * 任务发布人进行报账审核
	 * @param taskno
	 * @param cause
	 * @param state
	 * @param fauditno
	 * @return
	 */
	int doFeeAudit(String cause,String state,String fauditno);
}
