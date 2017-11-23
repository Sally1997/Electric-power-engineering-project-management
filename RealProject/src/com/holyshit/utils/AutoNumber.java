package com.holyshit.utils;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.ProjectStage;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

public class AutoNumber {
	//1位项目类型+4位项目编号+1位层号+1位阶段+3位任务+1位指标
	
	/**
	 * 根据项目编号获取阶段编号
	 * @return 阶段编号
	 * @throws SQLException 
	 */
	public String PNtoSN(String pn) throws SQLException{
		ProjectStage pro_stage = new ProjectStage();
		
		pro_stage.setProjectNo(pn);
		//根据项目编号获取阶段编号
		ProjectService pros = new ProjectServiceImpl();
		List<Object> list = pros.getNewStageNo(pn);
		//获取降序后的第一个阶段编号，即最大的那个
		String newsn_1 = list.get(0).toString();
		//获取阶段编号的第两位
		String newsn_2 = newsn_1.substring(newsn_1.length()-2, newsn_1.length());
		int x = Integer.parseInt(newsn_2);
		//编号加1
		x++;
		
		String s = "";
		if(x<10){
			s += "0";
		}
		s += String.valueOf(x);
		String ss = pn;
		//项目编号加上x
		ss+=s;
		return ss;
	}
}
