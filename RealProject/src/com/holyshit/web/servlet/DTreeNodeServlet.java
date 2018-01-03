package com.holyshit.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.DTree;
import com.holyshit.domain.Project;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;

import net.sf.json.JSONArray;

public class DTreeNodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pn = request.getParameter("pno");
		
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//获取到项目信息
		list = dtns.GetTreeInfo(pn);
		
		//转换成JSON数组
		String s = JSONArray.fromObject(list).toString();
		//这里有一个问题，转发过去的json数组前台接收获取到的内容和解析ajax内容不太一样，这里先存疑
		
		request.setAttribute("s", s);
		request.getRequestDispatcher("/jsp/projectManage/PlanManagement_Newed.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
