package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class ShowStaffByPage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pageSize=Integer.parseInt(request.getParameter("limit"));
		int cur=(Integer.parseInt(request.getParameter("offset"))/pageSize)+1;
		//获取员工信息
		StaffService ss=new StaffServiceImpl();
		Map<String, Object> res = ss.findStaffByPage(cur, pageSize);
		
		//封装json数组
		JSONArray ja=new JSONArray();
		for(Staff s:(List<Staff>)res.get("staffs")){
			JSONObject jo=new JSONObject();
			jo.put("staffno", s.getStaffno());
			jo.put("name", s.getName());
			jo.put("sex", s.getSex());
			jo.put("birthday", s.getBirthday().toString());
			jo.put("te", s.getTe());
			jo.put("email", s.getEmail());
			ja.add(jo);
		}
		JSONObject hehe=new JSONObject();
		hehe.put("total", (Long)res.get("totalNum"));
		hehe.put("rows", ja);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(hehe.toString());
	}

}
