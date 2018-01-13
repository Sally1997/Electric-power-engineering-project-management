package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

public class ListNameNoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取数据库返回信息
		AccountService as = new AccountServiceImpl();
		String str="";
		try {
			List<Staff> list = as.getNameNoByName(request.getParameter("msg"));
			for(int i=0;i<list.size();i++){
				if(i>0)
					str+=",";
				str+=(list.get(i).getName()+"("+list.get(i).getStaffno()+")");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//把数据相应到客户端
		PrintWriter out = response.getWriter();
		out.write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
