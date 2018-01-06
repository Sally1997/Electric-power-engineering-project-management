package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;
import com.holyshit.utils.AutoNumber;

/**
 * Servlet implementation class StageServlet
 */
public class StageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		String pn = request.getParameter("pno");
		System.out.println("怎么过来的？");
		
		PSPlan pro_stage = new PSPlan();
		TaskIndexs task_index = new TaskIndexs();
		
		//List<PSPlan> plist = new ArrayList<PSPlan>();
		//List<TaskIndexs> tlist = new ArrayList<TaskIndexs>();
		
		PrintWriter out = response.getWriter();
		Enumeration e = request.getParameterNames();
		
		//日期转换
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		int x7 = 7;
		String[] icArray = null;
		String[] anArray = null;
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value=request.getParameter(name);
			//out.write(name+"="+value);
		    if(name.equals("fozza_sn")){
		    	pro_stage.setSname(value);
		    }
		    if(name.equals("fozza_cp")){
		    	//审批人
				String rcpn = value;
				String cpn = "";
				for(int i=0;i<12;i++){
					cpn+=rcpn.charAt(rcpn.length()-13+i);
				}
				pro_stage.setCharpno(cpn);
		    }
		    if(name.equals("fozza_st")){
		    	try {
		    		java.util.Date d = sdf.parse(value);
		    		java.sql.Date date = new java.sql.Date(d.getTime());
					pro_stage.setStime(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name.equals("fozza_et")){
		    	try {
		    		java.util.Date d = sdf.parse(value);
		    		java.sql.Date date = new java.sql.Date(d.getTime());
					pro_stage.setEtime(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name.equals("fozza_bg")){
		    	pro_stage.setBudget(value);
		    }
		    if(name.equals("indexcontent")){
		    	icArray = value.split(",");
		    }
		    if(name.equals("attachmentneed")){
		    	anArray = value.split(",");
		    }
		    
		  //x自减为0时
		    x7--;
		    if(x7==0){
		    	x7=7;
		    	//从表单里面获取到的阶段信息有阶段名称，审批人编号，开始结束日期，预算
		    	//获取到项目编号，状态置为0，生成阶段编号
		    	//获取到指标内容数组，是否需要上传文件数组
		    	pro_stage.setPno(pn);
		    	pro_stage.setSstate("0");
		    	//生成阶段编号
		    	AutoNumber an = new AutoNumber();
		    	String sn = "";
				try {
					sn = an.PNtoSN(pn);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pro_stage.setStageno(sn);
		    	System.out.println(pro_stage);
		    	ProjectStageSercvice pss = new ProjectStageServiceImpl();
		    	pss.AddStage(pro_stage);
		    	
		    	StageTasksService sts = new StageTasksServiceImpl();
		    	
		    	//指标的新建
		    	int len = icArray.length;
		    	for(int i=0;i<len;i++){
		    		System.out.println(icArray[i]);
		    		task_index = new TaskIndexs();
		    		task_index.setTaskno(pro_stage.getStageno());
		    		task_index.setIndexinfo(icArray[i]);
		    		task_index.setAchreq(anArray[i]);
		    		task_index.setIndexstate("0");
		    		sts.addIndexInfo(task_index);
		    	}
		    	
		    	pro_stage = new PSPlan();
		    }
		}
		
		//分发转向
		//response.setHeader("refresh", "0.5;url=/RealProject/servlet/DTreeNodeServlet?pno="+pn);		
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
