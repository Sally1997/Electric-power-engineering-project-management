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
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;

public class TaskIndexAudit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		String [] index = request.getParameterValues("indexbox");
		String agree = request.getParameter("agree");
		String stageno = request.getParameter("taskno");
		String charpno = request.getParameter("charpno");
		
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		Inform info = new Inform();
		if(agree.equals("agree")){
			agree="2";
			info.setMtype("A6");
		}
		else{
			agree="1";
			info.setMtype("A9");
		}
		
		String pno = stageno.substring(0,5);
		ProjectService ps = new ProjectServiceImpl();
		ps.changeProjectStage(pno);
		
		info.setBusno(stageno);
		info.setDstpno(charpno);
		info.setSrcpno(staff.getStaffno());
		
		AuditService as = new AuditServiceImpl();
		
		if(index!=null){
			as.StageIndexAudit(info, index);
		}
		
		//跳转到信息表？
		response.getWriter().write("<script type='text/javascript'>alert('审核成功!')</script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/web/servlet/shouInformServlet?type=1");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
