package com.holyshit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.DocumentService;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.DocumentServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;

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
		String aflag = request.getParameter("aflag");
		String flag = (String)request.getSession().getAttribute("flag");
		if(flag.equals(aflag))
		{
			String me = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
			String dno = request.getParameter("dno");
			String who = request.getParameter("who");
			String type = request.getParameter("type");
			System.out.println("dno:"+dno+" type:"+type);
			DocumentService ds = new DocumentServiceImpl();
			ds.auditfile(type, dno);
			InformService is = new InformServiceImpl();
			if(type!="")
			{
				is.insertinformdocaudit(dno,who, me, "A3");
			}
			else {
				is.insertinformdocaudit(dno,who, me, "A4");
			}
		}
		
		
		request.getRequestDispatcher("/web/servlet/showDocumentCheckServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
