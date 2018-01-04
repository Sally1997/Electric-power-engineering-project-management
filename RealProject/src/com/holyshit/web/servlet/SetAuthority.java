package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.AuthorityService;
import com.holyshit.service.impl.AuthorityServiceImpl;

public class SetAuthority extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String staffno=request.getParameter("staffno");
		String list=request.getParameter("list");
		if(staffno==null||list==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		//调用服务
		AuthorityService as=new AuthorityServiceImpl();
		boolean res=as.setAuthority(staffno,list);
		if(res){
			response.getWriter().write("ok");
		}else {
			response.getWriter().write("error");
		}
		
	}

}
