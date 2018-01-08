package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Authority;
import com.holyshit.domain.Qualification;
import com.holyshit.domain.Staff;
import com.holyshit.service.AuthorityService;
import com.holyshit.service.QualificationService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.AuthorityServiceImpl;
import com.holyshit.service.impl.QualificationServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

@WebServlet("/web/showUserCenterServlet")
public class ShowUserCenterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShouUserCenterNow");
		String staffno=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		StaffService ss = new StaffServiceImpl();
		Staff me = ss.findAStaff(staffno);
		QualificationService qfs = new QualificationServiceImpl();
		List<Qualification> qL = qfs.findAllQualifications(staffno);
		AuthorityService as = new AuthorityServiceImpl();
		List<Authority> aList = as.findAuthorityById(staffno);
		String defaultauth = "";
		if(aList.isEmpty())
		{
			defaultauth = "无特殊权限";
			
		}
		request.setAttribute("defaultauth",defaultauth );	
		request.setAttribute("aList",aList );
		request.setAttribute("me",me );
		request.setAttribute("qL",qL );
		request.getRequestDispatcher("/jsp/projectManage/UserCenter.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
