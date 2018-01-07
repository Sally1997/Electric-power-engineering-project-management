package com.holyshit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.QualificationService;
import com.holyshit.service.impl.QualificationServiceImpl;

/**
 * Servlet implementation class AddQualificationServlet
 */
@WebServlet("/web/servlet/addQualificationServlet")
public class AddQualificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addqualificationnow");
		String staffno = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String qua=request.getParameter("qua");//将Usercenter添加资格证的输入框的name设置成qua
		QualificationService qfs = new QualificationServiceImpl();
		qfs.AddAQualification(staffno,qua);
		request.getRequestDispatcher("/web/showUserCenterServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
