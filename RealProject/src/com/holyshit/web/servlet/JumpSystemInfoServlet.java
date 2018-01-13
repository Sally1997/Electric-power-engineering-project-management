package com.holyshit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.InformService;
import com.holyshit.service.impl.InformServiceImpl;

/**
 * Servlet implementation class JumpSystemInfoServlet
 */
@WebServlet("/web/servlet/jumpSystemInfoServlet")
public class JumpSystemInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JumpSystemInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String mno = request.getParameter("mno");
		if(type.equals("2")||type.equals("4"))
		{
			InformService is = new InformServiceImpl();
			is.updatehasread(mno);
			request.setAttribute("type", "2");
			request.getRequestDispatcher("/web/servlet/shouInformServlet").forward(request, response);
		}
		else if(type.equals("3")||type.equals("5"))
		{
			InformService is = new InformServiceImpl();
			is.updatehasread(mno);
			request.getRequestDispatcher("/web/showUserCenterServlet").forward(request, response);
		}
		else {
			InformService is = new InformServiceImpl();
			is.updatehasread(mno);
			String pnojump = request.getParameter("pno");
			request.setAttribute("pno", pnojump);
			request.getRequestDispatcher("/web/servlet/canJumpProServlet").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
