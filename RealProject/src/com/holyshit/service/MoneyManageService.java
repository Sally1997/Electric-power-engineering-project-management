package com.holyshit.service;

import java.util.Map;

public interface MoneyManageService {
	/***
	 * 分页显示项目资金情况
	 * @param cur 当前页
	 * @param pagesize 页大小
	 * @param id  用户id
	 * @return
	 */
	Map<String, Object> showProjectMoneyPage(int cur,int pagesize,String id);
}
