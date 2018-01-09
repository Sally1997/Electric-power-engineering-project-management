package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class GetRootInfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用服务
		StaffService ss=new StaffServiceImpl();
		Staff info = ss.findRootInfo();
		if(info!=null){
			JSONObject jo=new JSONObject();
			jo.put("staffno", info.getStaffno());
			jo.put("name", info.getName());
			jo.put("sex", info.getSex());
			jo.put("birthday", info.getBirthday().toString());
			jo.put("te", info.getTe());
			jo.put("email", info.getEmail());
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jo.toString());
			
		}else{
			response.getWriter().write("error");
		}
	}

}
