package com.holyshit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.InformService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.InformServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

/**
 * Servlet implementation class CanJumpProServlet
 */
@WebServlet("/web/servlet/canJumpProServlet")
public class CanJumpProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CanJumpProServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String me=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String pno = request.getParameter("pno");
		String mno = request.getParameter("mno");
		StaffService ss = new StaffServiceImpl();
		InformService is = new InformServiceImpl();
		int a = ss.isinproject(me, pno);
		if(a==0)
		{
			is.updatehasread(mno);
			request.getRequestDispatcher("/web/servlet/shouInformServlet?type=1").forward(request, response);
		}
		else {
			
			is.updatehasread(mno);
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("/web/servlet/staffListServlet").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
