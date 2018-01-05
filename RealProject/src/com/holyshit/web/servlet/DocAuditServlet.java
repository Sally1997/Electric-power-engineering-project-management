package com.holyshit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.AuditService;
import com.holyshit.service.impl.AuditServiceImpl;


public class DocAuditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String dno = request.getParameter("dno");
		String agree = request.getParameter("agree");
		String adv = request.getParameter("auditinfo");
		
		if(agree.equals("agree")){
			agree="2";
		}
		else{
			agree="1";
		}
		AuditService as = new AuditServiceImpl();
		as.changeDocAuditState(adv, agree, dno);
		
		//审核完了跳转到消息界面？
		//request.getRequestDispatcher("").forward(request, response);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
