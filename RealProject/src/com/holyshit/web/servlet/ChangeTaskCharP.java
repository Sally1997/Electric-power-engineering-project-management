package com.holyshit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class ChangeTaskCharP extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		String rcpn = request.getParameter("rcpn");
		String node = request.getParameter("node");
		
		String cpn = "";
		for(int i=0;i<12;i++){
			cpn+=rcpn.charAt(rcpn.length()-13+i);
		}
		
		String pno = node.substring(0,5);
		StageTasksService sts = new StageTasksServiceImpl();
		sts.changeCharP(pno, node, cpn);
		
		String S = "修改负责人成功!";
		response.getWriter().write(S);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
