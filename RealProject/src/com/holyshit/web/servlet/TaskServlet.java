package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Inform;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;
import com.holyshit.utils.AutoNumber;

public class TaskServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		String staffno = staff.getStaffno();
		
		String ptn = request.getParameter("ptn");
		String pn = request.getParameter("pno");
		
		String ptype;
		if(ptn.length()==6){
			ptype = "0";
		}
		else{
			ptype = "1";
		}
		String sn = ptn.substring(0, 6);
		
		Enumeration<String> e = request.getParameterNames();
		
		//日期转换
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		//新建阶段个数
		int len = 0;
		
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value[] = request.getParameterValues(name);
			if(name.equals("fozza_sn")){
		    	len = value.length;
		    	break;
		    }
		}
		
		StageTask[] parray = new StageTask[len];
		Inform[] iArray = new Inform[len];
		PSRelation[] prArray = new PSRelation[len];
		
		//index content 和 attachment need
		String[] icArray = new String[len];
		String[] anArray = new String[len];
		
		for(int i=0;i<len;i++){
			parray[i] = new StageTask();
			iArray[i] = new Inform();
			prArray[i] = new PSRelation();
			icArray[i] = new String();
			anArray[i] = new String();
		}
		
		e = request.getParameterNames();
		
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value[] = request.getParameterValues(name);
			
			for(int i=0;i<len;i++){
				if(name.equals("fozza_sn")){
					//项目名称以及其他
					parray[i].setTaskname(value[i]);
					//设置项目编号和初始状态
					parray[i].setPno(pn);
					parray[i].setStageno(sn);
				    parray[i].setPtaskno(ptn);
				    parray[i].setTstate("0");
				    parray[i].setPtasktype(ptype);
				    
				    //设置消息相关
				    iArray[i].setSrcpno(staffno);
				    iArray[i].setMtype("T3");
				    
				    //设置人员关系
				    prArray[i].setPno(pn);
				    prArray[i].setDuty("负责人");
			    }
				if(name.equals("fozza_cp")){
			    	//负责人
					String rcpn = value[i];
					String cpn = "";
					for(int j=0;j<12;j++){
						cpn+=rcpn.charAt(rcpn.length()-13+j);
					}
					parray[i].setCharpno(cpn);
					
					iArray[i].setDstpno(cpn);
					
					prArray[i].setStaffno(cpn);
			    }
			    if(name.equals("fozza_st")){
			    	try {
			    		java.util.Date d = sdf.parse(value[i]);
			    		java.sql.Date date = new java.sql.Date(d.getTime());
			    		parray[i].setStime(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			    if(name.equals("fozza_et")){
			    	try {
			    		java.util.Date d = sdf.parse(value[i]);
			    		java.sql.Date date = new java.sql.Date(d.getTime());
			    		parray[i].setEtime(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			    if(name.equals("fozza_bg")){
			    	parray[i].setBudget(value[i]);
			    }
			    if(name.equals("indexcontent")){
			    	icArray[i] = value[i];
			    }
			    if(name.equals("attachmentneed")){
			    	anArray[i] = value[i];
			    }
			}
		}
		
		StageTasksService sts = new StageTasksServiceImpl();
		sts.addTaskAndIndex(ptn, pn, parray, icArray, anArray, iArray, prArray);
		
		//分发转向
		response.setHeader("refresh", "0.5;url=/RealProject/servlet/DTreeNodeServlet?pno="+pn);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
