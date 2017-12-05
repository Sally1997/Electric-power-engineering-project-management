package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/servlet/ShowProjectServlet")
public class ShowProjectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		List<ProjectInfo> list = new ArrayList<ProjectInfo>();
		ProjectService ps = new ProjectServiceImpl();
		list = ps.getProjectInfo();
		//一类为设计类，对应字符''0'',一类为工程类,对应字符''1''
		//项目状态有''0''——立项审核中；''1''正常进行中,''2''逾期进行中,''3’按时完工，''4''逾期竣工。。'
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPType().equals("0")){
				list.get(i).setPType("设计类");
			}
			else{
				list.get(i).setPType("工程类");
			}
			switch(list.get(i).getpState()){
			case "0":
				list.get(i).setpState("立项审核中");
				break;
			case "1":
				list.get(i).setpState("正常进行中");
				break;
			case "2":
				list.get(i).setpState("逾期进行中");
				break;
			case "3":
				list.get(i).setpState("按时完工");
				break;
			case "4":
				list.get(i).setpState("逾期竣工");
				break;
			}
		}
		/*for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}*/
		
		/*
		 * 以JSON数组的形式返回
		 * String s = JSONArray.fromObject(list).toString();
		response.getWriter().write(s);
		System.out.println(s);*/
		
		if(list!=null){
			request.setAttribute("dawdlist",list);
			request.getRequestDispatcher("/jsp/projectManage/projectmanagerfirst.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
