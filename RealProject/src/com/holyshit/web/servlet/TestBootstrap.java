package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestBootstrap extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String par = request.getParameter("status");
		
		System.out.println(par);
		
		JSONArray array=new JSONArray();
		for(int i=0;i<8;i++){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("staffno", "3456");
			jsonObject.put("name", "王大锤");
			jsonObject.put("birthday", "1997-9-9");
			array.add(jsonObject);
		}
		JSONObject res=new JSONObject();
		res.put("total", 22);
		res.put("rows", array);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(res.toString());
		
	}

}
