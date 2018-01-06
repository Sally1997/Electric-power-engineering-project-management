package com.holyshit.service;

import java.util.Map;

import com.holyshit.domain.Inform;

public interface InformService {
	/**
	 * 获得最新生成的项目审核主键编号
	 * @return
	 */
	String getNewPaauditNo();
	
	/**
	 * 添加信息表信息
	 * @param info
	 */
	void addInform(Inform info);
	
	/**
	 * 获得inform
	 * @param mno
	 * @return
	 */
	Inform getInformByMno(String mno);
	
	/**
	 * 查询各种类型消息的数量 
	 * @param staffno
	 * @param type
	 * @return
	 */
	Map<String,Object> findInformNumber(String staffno);
	
}
