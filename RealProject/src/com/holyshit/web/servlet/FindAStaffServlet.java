package com.holyshit.web.servlet;

import static org.hamcrest.CoreMatchers.nullValue;


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
		System.out.println("跳到了查找的Servlet");
		String SearchStaffNo=request.getParameter("SearchStaffNo");
		System.out.println("搜索staffno"+SearchStaffNo);
		String pno = request.getParameter("pno");
		StaffService ssi = new StaffServiceImpl();
		
		if(SearchStaffNo.length()!=12)
		{
			String error = "您输入的员工编号不符合要求，必须为12位";
			List<Qualification> Qualifications = null;
			Staff staff = new Staff();
			request.setAttribute("Qualifications", Qualifications);
			request.setAttribute("hrstaff", staff);
			request.setAttribute("error", error);
			request.setAttribute("pno", pno);
			request.setAttribute("lastSearchStaffNo", "");
			request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
		}
		else {
			Staff staff = ssi.findAStaff(SearchStaffNo);
			if(staff==null)
			{
				System.out.println("用户不存在");
				String error = "用户不存在";
				List<Qualification> Qualifications = null;
				request.setAttribute("Qualifications", Qualifications);
				request.setAttribute("hrstaff", null);
				request.setAttribute("error", error);
				request.setAttribute("pno", pno);
				request.setAttribute("lastSearchStaffNo", "");
				request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("hrstaff", staff);
				request.setAttribute("SearchStaffNo", SearchStaffNo);
				System.out.println("信息：");
				System.out.println("编号："+staff.getStaffno());
				System.out.println("姓名："+staff.getName());
				System.out.println("邮箱："+staff.getEmail());
				System.out.println("联系方式："+staff.getTe());
				QualificationService qs = new QualificationServiceImpl();
				List<Qualification> Qualifications = qs.findAllQualifications(SearchStaffNo);
				for(int i=0;i<Qualifications.size();i++)
				{
					System.out.println(Qualifications.get(i).getQualifdesc());
				}
				request.setAttribute("Qualifications", Qualifications);
				request.setAttribute("lastSearchStaffNo", staff.getStaffno());
				request.setAttribute("pno", pno);
				request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
