package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;
import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class ShowPageProjectBudget extends HttpServlet {
	/**
	 * 此方法通过网页servlet请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前页以及页大小
		request.setCharacterEncoding("UTF-8");
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pagesize=Integer.parseInt(request.getParameter("pageSize"));
		//获取用户id
		HttpSession session=request.getSession();
		String staffno = ((Staff)session.getAttribute("staff")).getStaffno();
		//调用服务
		MoneyManageService ms=new MoneyManageServiceImpl();
		Map<String, Object> res=ms.showProjectMoneyPage(cur, pagesize, staffno);
		
		request.setAttribute("projects", res);
		
		//分发
		request.getRequestDispatcher("/moneymanage.jsp").forward(request, response);
	}

	/**
	 * 此方法通过ajax请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
