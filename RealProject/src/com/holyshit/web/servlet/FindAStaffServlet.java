package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

/**
 * Servlet implementation class FindAStaffServlet
 */
@WebServlet("/web/servlet/findAStaffServlet")
public class FindAStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到了查找的Servlet");
		String SearchStaffNo=request.getParameter("SearchStaffNo");
		System.out.println("搜索staffno"+SearchStaffNo);
		StaffService ssi = new StaffServiceImpl();
		Staff Staff = ssi.findAStaff(SearchStaffNo);
		request.setAttribute("Staff", Staff);
		request.setAttribute("SearchStaffNo", SearchStaffNo);
		System.out.println("信息：");
		System.out.println("编号："+Staff.getStaffno());
		System.out.println("姓名："+Staff.getName());
		System.out.println("邮箱："+Staff.getEmail());
		System.out.println("联系方式："+Staff.getTe());
		request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
