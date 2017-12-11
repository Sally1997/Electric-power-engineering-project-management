package com.holyshit.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Project;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.utils.AutoNumber;

@WebServlet({ "/NewProjectServlet", "/servlet/NewProjectServlet" })
public class NewProjectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		Project pro = new Project();
		//新建项目名称
		pro.setPname(request.getParameter("ProjectName"));
		
		//0为射击类，1为工程类 项目编号
		String s = request.getParameter("ProjectType");
		String x;
		if(s.equals("工程类")){
			x="1";
		}
		else{
			x="0";
		}
		pro.setPtype(x);
		
		//根据项目类型生成项目编号
		AutoNumber au = new AutoNumber();
		pro.setPno(au.PTypeToPNo(x));
		
		//审批人-->项目经理
		String rcpn = request.getParameter("PersonInCharge");
		String cpn = "";
		for(int i=0;i<12;i++){
			cpn+=rcpn.charAt(rcpn.length()-13+i);
		}
		pro.setPmno(cpn);
		
		//项目阶段初始化为立项中
		pro.setPstate("0");
		//阶段初始化为0
		pro.setPstage("0");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		pro.setStime((java.sql.Date) new Date());
		
		//预算和结束时间未设置
		System.out.println(pro.getPname());
		
		ProjectService ps = new ProjectServiceImpl();
		ps.NewProject(pro);
		
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/jsp/projectManage/projectmanagerfirst.jsp");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
