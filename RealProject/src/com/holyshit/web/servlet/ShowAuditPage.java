package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;
import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class ShowAuditPage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pagesize=Integer.parseInt(request.getParameter("pageSize"));
		HttpSession session=request.getSession();
		Staff staff=(Staff) session.getAttribute("staff");
		
		MoneyManageService ms=new MoneyManageServiceImpl();
		String res = ms.showAuditInfoPageById(cur, pagesize, staff.getStaffno());
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);
	}

	
}
