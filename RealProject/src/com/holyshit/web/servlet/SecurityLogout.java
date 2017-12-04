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

public class SecurityLogout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ServletContext sc = request.getServletContext();
			//从session链表中删除当前session
			List<HttpSession> sessionlist=(List<HttpSession>) sc.getAttribute("sessionlist");
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
