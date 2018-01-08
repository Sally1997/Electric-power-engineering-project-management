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
		String pno = request.getParameter("pno");
		PSRelation psr = new PSRelation();
		String duty = request.getParameter("duty");
		String SearchStaffNo = request.getParameter("SearchStaffNo");
		psr.setPno(pno);
		psr.setDuty(duty);
		psr.setStaffno(SearchStaffNo);	
		StaffService ssi = new StaffServiceImpl();
		ssi.addAStaff(psr);
		request.setAttribute("pno", pno);
		String error = "添加成功";
		request.setAttribute("error", error);
		request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
