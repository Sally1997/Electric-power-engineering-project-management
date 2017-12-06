package com.holyshit.utils;

import java.util.List;

import com.holyshit.domain.ProjectInfo;

public class StateConversion {
	//该类以后作为将各种state映射到字符串用
	
	//项目类型转换,一类为设计类，对应字符''0'',一类为工程类,对应字符''1''
	public void PTypeConversion(List<ProjectInfo> list){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPType().equals("0")) {
				list.get(i).setPType("设计类");
			} else {
				list.get(i).setPType("工程类");
			}
		}
	}
	
	//项目状态有''0''——立项审核中；''1''正常进行中,''2''逾期进行中,''3’按时完工，''4''逾期竣工。。'
	public void PStateConversion(List<ProjectInfo> list){
		for(int i=0;i<list.size();i++){
			switch(list.get(i).getpState()){
			case "0":
				list.get(i).setpState("立项审核中");
				break;
			case "1":
				list.get(i).setpState("正常进行中");
				break;
			case "2":
				list.get(i).setpState("逾期进行中");
				break;
			case "3":
				list.get(i).setpState("按时完工");
				break;
			case "4":
				list.get(i).setpState("逾期竣工");
				break;
			}
		}
	}
}
