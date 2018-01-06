package com.holyshit.service;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	/**
	 * 查找相应类型的消息数据
	 * @param staffno
	 * @param type
	 * @return
	 */
	JSONArray findInformByType(String staffno,String type);
	
}
