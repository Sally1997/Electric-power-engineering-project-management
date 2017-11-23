package com.holyshit.web.servlet;
<<<<<<< HEAD

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.Account;
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

public class StaffLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//»ñÈ¡±íµ¥
		Account account=new Account();
		
		try {
			BeanUtils.populate(account, request.getParameterMap());
			account.setLltime(new Date(new java.util.Date().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code=request.getParameter("validatecode");
		//ÊÇ·ñµÇÂ½³É¹¦
		AccountService as=new AccountServiceImpl();
		boolean res=false;
		Map<String, String> error=new HashMap<String, String>();
		HttpSession session = request.getSession();

		if(code.equals(session.getAttribute("validatecode"))){
			if(as.login(account)){
				res=true;
			
			}
			else {
			
				error.put("username", "ÓÃ»§Ãû»òÕßÃÜÂë´íÎó");
			}
		}else {
		
			error.put("validatecode", "ÑéÖ¤Âë´íÎó");
		}	
		//·Ö·¢×ªÏò
		if(res){
			//ÉèÖÃsession
			session.removeAttribute("validatecode");
			session.setAttribute("account", account);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("µÇÂ½³É¹¦");
			//cookie
			//Ìø×ªÊ×Ò³
		}else{
		
			request.setAttribute("error", error);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	System.out.println("µÇÂ½¹ý³Ì½áÊø");
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.Account;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.service.AccountService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.AccountServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class StaffLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//ï¿½ï¿½È¡ï¿½ï¿½
		Account account=new Account();
		try {
			BeanUtils.populate(account, request.getParameterMap());
			account.setLltime(new Date(new java.util.Date().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code=request.getParameter("validatecode");
		//ï¿½Ç·ï¿½ï¿½Â½ï¿½É¹ï¿½
		AccountService as=new AccountServiceImpl();
		boolean res=false;
		Map<String, String> error=new HashMap<String, String>();
		HttpSession session = request.getSession();

		if(code.equals(session.getAttribute("validatecode"))){
			if(as.login(account)){
				res=true;
			
			}
			else {
			
				error.put("username", "ç”¨æˆ·åæˆ–è€…å¯†ç é”™è¯¯");
			}
		}else {
		
			error.put("validatecode", "éªŒè¯ç é”™è¯¯");
		}	
		//ï¿½Ö·ï¿½×ªï¿½ï¿½
		if(res){

			//ï¿½ï¿½ï¿½ï¿½session
			session.removeAttribute("validatecode");
			//èŽ·å–ç”¨æˆ·çš„ä¿¡æ¯
			Staff staff = as.getUserById(account.getStaffno());
			session.setAttribute("staff", staff);
			//è·³è½¬åˆ°ç›¸åº”çš„uri
			String uri=request.getParameter("uri");
			if(uri!=null){
				//è·³å…¥ç›¸åº”çš„ç•Œé¢
				response.sendRedirect(uri);
			}
			else {
				//è¿›å…¥ä¸»é¡µ
				request.setAttribute("staffno", account.getStaffno());
				request.getRequestDispatcher("/web/servlet/mainServlet").forward(request, response);
			}
		}else{
		
			request.setAttribute("error", error);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
	}

}
