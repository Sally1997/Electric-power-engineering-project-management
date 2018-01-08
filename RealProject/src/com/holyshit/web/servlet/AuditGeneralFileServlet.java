package com.holyshit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

/**
 * Servlet implementation class AuditGeneralFileServlet
 */

public class AuditGeneralFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("auditfilenow");
		String dno = request.getParameter("dno");
		String type = request.getParameter("type");//1为通过，0为不通过
		System.out.println("dno:"+dno+" type:"+type);
		DocumentService ds = new DocumentServiceImpl();
		ds.auditfile(type, dno);
		request.getRequestDispatcher("/web/servlet/showDocumentCheckServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
