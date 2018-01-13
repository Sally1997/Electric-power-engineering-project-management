package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class GetFeeAuditDetailByFauditno extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String fauditno=request.getParameter("fauditno");
		if(fauditno==null){
			response.getWriter().write("error");
			return;
		}
		MoneyManageService mms=new MoneyManageServiceImpl();
		String res = mms.findFeeauditById(fauditno);
		response.getWriter().write(res);
	}

}