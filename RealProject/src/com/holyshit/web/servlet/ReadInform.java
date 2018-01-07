package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.InformService;
import com.holyshit.service.impl.InformServiceImpl;

public class ReadInform extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mno=request.getParameter("mno");
		if(mno==null){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			return;
		}
		
		//调用服务
		InformService informService=new InformServiceImpl();
		boolean res = informService.readInform(mno);
		if(res){
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("error");
		}
	}

}
