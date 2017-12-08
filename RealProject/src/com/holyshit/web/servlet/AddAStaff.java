package com.holyshit.web.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.PSRelation;
import com.holyshit.domain.StaffDuty;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;
import com.mchange.v2.codegen.bean.BeangenUtils;

public class AddAStaff extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("geegeegeegeebabybayby");
		String pno = request.getParameter("pno");
		System.out.println("shenmewanyiaaaaaaaaaaa ");
		PSRelation psr = new PSRelation();
		String duty = request.getParameter("duty");
		String SearchStaffNo = request.getParameter("SearchStaffNo");
		psr.setPno(pno);
		psr.setDuty(duty);
		psr.setStaffno(SearchStaffNo);
		System.out.println("i am here 1PNO="+pno);
		/*
		try {
			BeanUtils.populate(psr, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		StaffService ssi = new StaffServiceImpl();
		ssi.addAStaff(psr);
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("${pageContext.request.contextPath}/web/servlet/hrMainJumpaddServlet?pno="+pno).forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
