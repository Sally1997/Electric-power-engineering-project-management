package com.holyshit.service;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.domain.Inform;

public interface InformService {
	/**
	 * 向消息表插入文档审核消息
	 * @param dno
	 * @param staffno
	 * @param me
	 * @param type
	 */
	void insertinformdocaudit(String dno,String staffno,String me,String type);
	
	void updatehasread(String mno);
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
	
	/**
	 * 读取消息，设置已读标记
	 * @param mno
	 * @return
	 */
	boolean readInform(String mno);
	
	/**
	 * 姐u但是否在审核中
	 * @param sno
	 * @return
	 */
	public Map<String,Object> askStageIfAudited(String sno);
	
	/**
	 * 任务是否在审核中
	 * @param tno
	 * @return
	 */
	public Map<String,Object> askTaskIfAudited(String tno);
}
