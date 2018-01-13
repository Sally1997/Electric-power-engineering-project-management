package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Inform;
import com.holyshit.service.AuditService;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;

public class ShowDocAudit extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String mno = request.getParameter("mno");
		String mno = "6";
		InformService is = new InformServiceImpl();
		Inform info = is.getInformByMno(mno);
		
		String pdauditno = info.getBusno();
		
		AuditService as = new AuditServiceImpl();
		Map<String,Object> map = as.getDocAuditInfo(pdauditno);
		
		String tmp = null;
		if(map.get("dtype").equals("1")){
			tmp = "学习资料";
		}
		else{
			tmp = "使用文档";
		}
		map.put("dtype", tmp);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/jsp/notice/checkdoc.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
