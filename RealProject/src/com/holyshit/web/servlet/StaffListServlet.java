package com.holyshit.web.servlet;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.PageBean;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaffListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转到了staffLISTservlet222222");
		String pno=request.getParameter("pno");
		System.out.println("跳转到了staffLISTservlet11111111");
		String noterno=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		//String noterno = "201526010001";
		System.out.println("stafflist里的noterno:"+noterno);
		System.out.println("跳转到了staffLISTservlet33333333333");
		int PageSize = 5;
		String currPage = request.getParameter("currPage");
		int CurrentPage = 1;
		if(currPage!=null)
		{
			CurrentPage = Integer.parseInt(currPage);
		}
		
		StaffService ssi = new StaffServiceImpl();
		PageBean pb = ssi.findAllStaffs(pno,CurrentPage,PageSize,noterno);
		request.setAttribute("pb", pb);
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("/jsp/projectManage/hr_main.jsp").forward(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
