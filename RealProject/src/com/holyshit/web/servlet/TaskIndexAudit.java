package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Inform;
import com.holyshit.domain.Staff;
import com.holyshit.service.AuditService;
import com.holyshit.service.impl.AuditServiceImpl;

public class TaskIndexAudit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String [] index = request.getParameterValues("indexbox");
		String agree = request.getParameter("agree");
		String stageno = request.getParameter("taskno");
		String charpno = request.getParameter("charpno");
		
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		
		if(agree.equals("agree")){
			agree="2";
		}
		else{
			agree="1";
		}
		
		Inform info = new Inform();
		
		info.setBusno(stageno);
		info.setDstpno(charpno);
		info.setSrcpno(staff.getStaffno());
		info.setMtype("5");
		info.setHasread("0");
		
		AuditService as = new AuditServiceImpl();
		as.StageIndexAudit(info, index);
		
		//跳转到信息表？
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
