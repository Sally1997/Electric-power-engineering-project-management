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
@WebServlet("/findAStaffServlet")
public class FindAStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SearchStaffNo=request.getParameter("SearchStaffNo");
		StaffService ssi = new StaffServiceImpl();
		Staff Staff = ssi.findAStaff(SearchStaffNo);
		request.setAttribute("Staff", Staff);
		request.setAttribute("SearchStaffNo", SearchStaffNo);
		request.getRequestDispatcher("/hr_add.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
