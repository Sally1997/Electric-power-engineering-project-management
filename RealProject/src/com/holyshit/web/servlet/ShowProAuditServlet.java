package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.holyshit.domain.Inform;
import com.holyshit.service.AuditService;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;

public class ShowProAuditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String mno = request.getParameter("mno");
		String mno=request.getParameter("mno");
		InformService is = new InformServiceImpl();
		Inform info = is.getInformByMno(mno);
		
		mno = info.getBusno();
		
		AuditService as = new AuditServiceImpl();
		String str = as.getProAuditInfo(mno);
		JSONObject jo = JSONObject.fromObject(str);
		Map map = jo;
		request.setAttribute("map", map);
		request.getRequestDispatcher("/jsp/notice/checkinfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
