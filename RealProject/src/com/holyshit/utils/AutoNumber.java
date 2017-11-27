package com.holyshit.utils;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.ProjectStage;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class AutoNumber {
	//1位项目类型+4位项目编号+1位层号+1位阶段+3位任务+1位指标
	//项目编号(char 5)-->阶段编号(char 6)-->任务编号(char 10)-->指标编号(char 11)
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
		String ss = pn;
		//获取降序后的第一个阶段编号，即最大的那个
		if(list.isEmpty()){
			ss+="0";
		}
		else{
			String newsn_1 = list.get(0).toString();
			
			String s = "";
			/*//获取阶段编号的第两位
			String newsn_2 = newsn_1.substring(newsn_1.length()-2, newsn_1.length());
			int x = Integer.parseInt(newsn_2);
			//编号加1
			x++;
			if(x<10){
				s += "0";
			}*/
			//获取阶段编号最后一位
			char x = newsn_1.charAt(newsn_1.length()-1);
			if(x!=9){
				x+=1;
			}
			else{//9的话进位到a,其他情况下加一
				x='a';
			}
			s += x;
			//项目编号加上x
			ss+=s;
		}
		return ss;
	}
	
	/**
	 * 根据阶段或者任务获取心得任务编号
	 * @param pn1
	 * @return
	 */
	public String CreateNewTaskNo(String pn1){
		String tn = pn1;
		if(pn1.length()==6){
			tn+="zzzz";
		}
		else{
			
		}
		return tn;
	}
	
	/**
	 * 根据任务编号获得索引编号
	 * @param tn 任务编号
	 * @return
	 * @throws SQLException 
	 */
	public String TNtoIN(String tn) throws SQLException{
		String in = tn;
		StageTasksService sts = new StageTasksServiceImpl();
		List<Object> list = sts.getNewIndexNo(tn);
		if(list.isEmpty()){
			in+="0";
		}
		else{
			String newtn_1 = list.get(0).toString();
			char x = newtn_1.charAt(newtn_1.length()-1);
			if(x!=9){
				x+=1;
			}
			else{
				x='a';//进位到a
			}
			in+=x;
		}
		return in;
	}
}
