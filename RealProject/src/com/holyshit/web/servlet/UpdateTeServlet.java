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

/**
 * Servlet implementation class UpdateTeServlet
 */
@WebServlet("/web/updateTeServlet")
public class UpdateTeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updatete now");
		String staffno = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String te=request.getParameter("te");
		String error1="";
		System.out.println("te"+te);
		if(te.length()!=11)
		{
			error1 = "您输入的联系方式不符合规范，请输入11位数字";
		}
		else 
		{
			int flag=0;
			for(int i=0;i<te.length();i++)
			{
				System.out.println("检查每一位:"+te.charAt(i));
				if(te.charAt(i)>'9'||te.charAt(i)<'0')
				{
					System.out.println("检查每一位"+i);
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("更新联系方式。");
				StaffService ss = new StaffServiceImpl();
				ss.updatete(staffno, te);
			}
			else {
				error1 = "您输入的联系方式不符合规范,其中包括非数字，请输入11位数字";
			}
		}
		System.out.println("error1:"+error1);
		
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
		request.setAttribute("error1",error1);
		request.setAttribute("me",me );
		request.setAttribute("qL",qL );
		
		request.getRequestDispatcher("/jsp/projectManage/UserCenter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
