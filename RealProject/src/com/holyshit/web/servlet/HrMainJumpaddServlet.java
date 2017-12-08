package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HrMainJumpaddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111111111111111111");
		String pno = request.getParameter("pno");
		System.out.println("取到了并跳转到了servlet，pno"+pno);
		System.out.println("aaaa"+request.getParameter("pno"));
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
