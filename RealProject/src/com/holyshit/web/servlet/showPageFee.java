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

public class showPageFee extends HttpServlet {
	/**
	 * 普通servlet请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Staff staff=(Staff) session.getAttribute("staff");
		MoneyManageService ms=new MoneyManageServiceImpl();
		Map<String, Object> res = ms.showFeeAuditInfoPage(1, 4, staff.getStaffno());
		//压入request
		request.setAttribute("fee", res);
		//转发到下一个servlet 
		request.getRequestDispatcher("/jsp/moneyManage/moneymanage.jsp").forward(request, response);
	}
	/**
	 * ajax方法请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
