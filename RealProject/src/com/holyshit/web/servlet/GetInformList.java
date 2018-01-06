package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;

public class GetInformList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Staff staff=(Staff)request.getSession().getAttribute("staff");
		String type=request.getParameter("type");
		if(staff==null){
			response.sendRedirect("/offline.html");
			return;
		}
		if(type==null){
			request.getRequestDispatcher("/error/error_500.jsp").forward(request, response);
			return;
		}
		
		
	}

}
