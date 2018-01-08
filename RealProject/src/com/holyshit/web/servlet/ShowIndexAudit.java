package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Inform;
import com.holyshit.service.AuditService;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;

public class ShowIndexAudit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String mno = request.getParameter("mno");
		String mno=request.getParameter("mno");
		Inform info = new Inform();
		InformService is = new InformServiceImpl();
		info = is.getInformByMno(mno);
		String taskno = info.getBusno();
		
		AuditService as = new AuditServiceImpl();
		Map<String,Object> map = as.getIndexAudit(taskno);
		
		request.setAttribute("map", map);
		
		//分发转向
		if(map.get("taskno")==null){//阶段
			request.getRequestDispatcher("/jsp/notice/checkstageindex.jsp").forward(request, response);
		}
		else{//任务
			request.getRequestDispatcher("/jsp/notice/checktaskindex.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
