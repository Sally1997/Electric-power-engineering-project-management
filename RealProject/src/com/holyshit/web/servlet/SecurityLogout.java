package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;

public class SecurityLogout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ServletContext sc = request.getServletContext();
			Staff staff=(Staff)request.getSession().getAttribute("staff");
			//从session链表中删除当前session
			List<HttpSession> sessionlist=(List<HttpSession>) sc.getAttribute("sessionlist");
			
			//删除人员链表中的对应项
			List<String> stafflist=(List<String>) sc.getAttribute("hasLoginedStaff");
			boolean resDe = stafflist.remove(staff.getStaffno());
			if(resDe){
				System.out.println("从人员链表删除"+staff.getStaffno());
			}
			int count = (Integer) sc.getAttribute("livingcount");
			count--;
			//在线人数减少1
			sc.setAttribute("livingcount", count);
			boolean flag = sessionlist.remove(request.getSession());
			if(flag){
				System.out.println("1人安全退出，当前在线人数："+count);
			}
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/offline.html");
	}

}
