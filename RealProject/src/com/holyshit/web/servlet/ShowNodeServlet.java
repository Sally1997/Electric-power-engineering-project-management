package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;

import net.sf.json.JSONObject;

public class ShowNodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//获取
		String no = request.getParameter("NodeNo");
		
		DTreeNodeService dtn = new DTreeNodeServiceImpl();
		Map<String,Object> map = new HashMap<String, Object>();
		map = dtn.GetNodeInfo(no);
		
		String s = JSONObject.fromObject(map).toString();
		//转换成json对象
		
		response.getWriter().write(s);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
