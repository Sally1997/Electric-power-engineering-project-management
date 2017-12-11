package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONObject;


@WebServlet("/servlet/ShowProjectServlet")
public class ShowProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		//定义当前页和页大小
		int current_page = 1;
		int page_size = 5;
		
		ProjectService ps = new ProjectServiceImpl();
		Map<String,Object> info_map = new HashMap<String, Object>();
		info_map = ps.getProjectManageInfo(current_page, page_size);
		
		request.setAttribute("info_map", info_map);
		request.getRequestDispatcher("/jsp/projectManage/projectmanagerfirst.jsp").forward(request, response);;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
