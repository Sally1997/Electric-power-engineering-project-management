package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class SubmitAudit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据
		String fauditno=request.getParameter("fauditno");
		String cause=request.getParameter("cause");
		String state=request.getParameter("state");
		if(fauditno==null || cause==null || state==null){
			response.getWriter().write("error");
		}
		//递交审核
		MoneyManageService ms=new MoneyManageServiceImpl();
		int res = ms.doFeeAudit(cause, state, fauditno);
		if(res==0){
			response.getWriter().write("error");
		}else {
			response.getWriter().write("ok");
		}
	}

}
