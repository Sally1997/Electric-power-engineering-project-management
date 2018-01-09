package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Qualification;
import com.holyshit.service.QualificationService;
import com.holyshit.service.impl.QualificationServiceImpl;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class QualificationListServlet
 */
@WebServlet("/web/servlet/qualificationListServlet")
public class QualificationListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到了资格SERVLET");
		String staffno = request.getParameter("staffno");
		QualificationService qfsi = new QualificationServiceImpl();
		List<Qualification> Qualifications = qfsi.findAllQualifications(staffno);
		System.out.println("00000000");
		for(int i=0;i<Qualifications.size();i++)
		{
			System.out.println(Qualifications.get(i).getQualifdesc());
		}
		request.setAttribute("Qualification", Qualifications);
		request.setAttribute("staffno", staffno);
		request.getRequestDispatcher("/jsp/projectManage/hr_main.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到了资格SERVLETPOST");
		String staffno = request.getParameter("staffno");
		QualificationService qfsi = new QualificationServiceImpl();
		List<Qualification> Qualifications = qfsi.findAllQualifications(staffno);
		String a = "";
		for(int i=0;i<Qualifications.size();i++)
		{
			a=a+"<tr><td>"+Qualifications.get(i).getQualifdesc()+"</td></tr>";
			System.out.println(Qualifications.get(i).getQualifdesc());
		}
		response.setContentType("text/xml;charset=UTF-8");
		response.getWriter().print(a);
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
