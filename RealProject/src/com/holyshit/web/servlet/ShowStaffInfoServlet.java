package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;
import com.holyshit.utils.AutoNumber;

import net.sf.json.JSONArray;

public class ShowStaffInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//project or company?
		String s = request.getParameter("type");
		
		//获取pno和staffno
		String pno = request.getParameter("pno");
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		String userno = staff.getStaffno();
		
		//返回的字符串str
		String str = "";
		
		//~~~~
		StaffService ss = new StaffServiceImpl();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		if(s.equals("ptype")){
			//如果选择类型是空或者project type则
			list = ss.showStaffInProject(pno, userno);
			String ja = JSONArray.fromObject(list).toString();
			AutoNumber an = new AutoNumber();
			str = an.transToArray(ja).toString();
		}
		else{
			list = ss.showStaffInCompany(pno, userno);
			//str = JSONArray.fromObject(list).toString();
			String ja = JSONArray.fromObject(list).toString();
			AutoNumber an = new AutoNumber();
			str = an.transToArray(ja).toString();
		}
		System.out.println(str);
		//返回字符串
		response.getWriter().write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
