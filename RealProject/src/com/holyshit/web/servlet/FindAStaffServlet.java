package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Qualification;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;
import com.holyshit.service.QualificationService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.QualificationServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

/**
 * Servlet implementation class FindAStaffServlet
 */
@WebServlet("/web/servlet/findAStaffServlet")
public class FindAStaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SearchStaffNo=request.getParameter("SearchStaffNo");
		String pno = request.getParameter("pno");
		StaffService ssi = new StaffServiceImpl();
		Staff Staff = ssi.findAStaff(SearchStaffNo);
		if(Staff==null)
		{
			String error = "用户不存在";
			request.setAttribute("error", error);
		}
		else
		{
			request.setAttribute("Staff", Staff);
			request.setAttribute("SearchStaffNo", SearchStaffNo);
			System.out.println("信息：");
			System.out.println("编号："+Staff.getStaffno());
			System.out.println("姓名："+Staff.getName());
			System.out.println("邮箱："+Staff.getEmail());
			System.out.println("联系方式："+Staff.getTe());
			QualificationService qs = new QualificationServiceImpl();
			List<Qualification> Qualifications = qs.findAllQualifications(SearchStaffNo);
			for(int i=0;i<Qualifications.size();i++)
			{
				System.out.println(Qualifications.get(i).getQualifdesc());
			}
			request.setAttribute("Qualifications", Qualifications);
			request.setAttribute("lastSearchStaffNo", Staff.getStaffno());
		}
		
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
