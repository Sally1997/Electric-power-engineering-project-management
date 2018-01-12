package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.holyshit.service.InformService;
import com.holyshit.service.impl.InformServiceImpl;

public class IfNodeIsAudited extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("nodeno");
		InformService is = new InformServiceImpl();
		
		String str = null;
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(no.length()==6){//jieduan
			map = is.askStageIfAudited(no);
		}
		else{
			map = is.askTaskIfAudited(no);
		}
		str = JSONObject.fromObject(map).toString();
		
		response.getWriter().write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
