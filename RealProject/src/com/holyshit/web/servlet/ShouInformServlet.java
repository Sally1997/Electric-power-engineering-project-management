package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.Dao.impl.TaskMesgDaoImpl;
import com.holyshit.domain.Staff;
import com.holyshit.domain.TaskMesg;
import com.holyshit.service.SystemMesgService;
import com.holyshit.service.TaskMesgService;
import com.holyshit.service.impl.SystemMesgServiceImpl;
import com.holyshit.service.impl.TaskMesgServiceImpl;

/**
 * Servlet implementation class ShouInformServlet
 */
@WebServlet("/web/servlet/shouInformServlet")
public class ShouInformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		TaskMesgService tms = new TaskMesgServiceImpl();
		String me=((Staff) request.getSession().getAttribute("staff")).getStaffno();
		List<TaskMesg> tasksinfo = tms.findAllTaskMesg(me);
		SystemMesgService sms = new SystemMesgServiceImpl();
		List<TaskMesg> systemsinfo = sms.findAllSystemMesg(me);
		request.setAttribute("systemsinfo",systemsinfo );
		request.setAttribute("tasksinfo",tasksinfo );
		request.setAttribute("type",type );
		request.getRequestDispatcher("/jsp/notice/inform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
