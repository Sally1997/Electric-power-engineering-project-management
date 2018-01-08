package com.holyshit.web.servlet;
import com.holyshit.domain.Staff;
import com.holyshit.service.*;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.*;
import com.holyshit.service.impl.StaffServiceImpl;
@WebServlet("/web/servlet/delAllStaffsServlet")
public class DelAllStaffsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到了批量删除的SERVLET");
		String me = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String[] staffnos = request.getParameterValues("ids");
		String pno=request.getParameter("pno");
		StaffService ss = new StaffServiceImpl();
		int flag=0;
		System.out.println(staffnos.length);
		for(int i=0;i<staffnos.length;i++)
		{
			if(staffnos[i].equals(me))
			{
				flag=1;
			}	
		}
		if(flag==1)
		{
			String[] staffnosexceptme = new String[staffnos.length-1];
			int count = 0;
			for(int k=0;k<staffnos.length;k++)
			{
				if(staffnos[k].equals(me))
				{
					count=count;
				}
				else {
					staffnosexceptme[count]=staffnos[k];
					count++;
				}
					
			}
			for(int i=0;i<staffnosexceptme.length;i++)
			{
				System.out.println(staffnosexceptme[i]);
			}
			ss.delAllStaffs(staffnosexceptme,pno,me);
		}
		else {
			ss.delAllStaffs(staffnos,pno,me);
		}
		
		
		
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("/web/servlet/staffListServlet?pno="+pno).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
