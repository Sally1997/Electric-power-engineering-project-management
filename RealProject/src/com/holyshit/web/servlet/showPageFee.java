package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.holyshit.domain.Staff;
import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class showPageFee extends HttpServlet {
	/**
	 * 普通servlet请求
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pagesize=Integer.parseInt(request.getParameter("pageSize"));
		HttpSession session=request.getSession();
		Staff staff=(Staff) session.getAttribute("staff");
		MoneyManageService ms=new MoneyManageServiceImpl();
		Map<String, Object> res = ms.showFeeAuditInfoPage(cur, pagesize, staff.getStaffno());
		//压入request
		request.setAttribute("fee", res);
		//转发到下一个servlet 
		if(pagesize==4)
			request.getRequestDispatcher("/jsp/moneyManage/moneymanage.jsp").forward(request, response);
		else {
			request.getRequestDispatcher("/jsp/moneyManage/moneyAccount.jsp").forward(request, response);
		}
	}
	/**
	 * ajax方法请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pagesize=Integer.parseInt(request.getParameter("pageSize"));
		//获取用户id
		HttpSession session=request.getSession();
		String staffno = ((Staff)session.getAttribute("staff")).getStaffno();
		//调用服务
		MoneyManageService ms=new MoneyManageServiceImpl();
		Map<String, Object> res = ms.showFeeAuditInfoPage(cur, pagesize, staffno);
		JSONObject json=new JSONObject();
		json.put("totalNum", res.get("totalNum"));
		json.put("feeaudits", res.get("feeaudits"));
		json.put("currentPage", res.get("currentPage"));
		json.put("pageNum", res.get("pageNum"));
		json.put("feeauditNum", res.get("feeauditNum"));
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
	}

}
