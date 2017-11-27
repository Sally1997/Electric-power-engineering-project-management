package com.holyshit.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;


public class TestCrud {
	@Test
	public void TestUpdate() throws SQLException{
		ProjectStage pro_stage = new ProjectStage();
		String pn="10001";
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
			System.out.println(x);
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
		System.out.println(ss);
	}
}
