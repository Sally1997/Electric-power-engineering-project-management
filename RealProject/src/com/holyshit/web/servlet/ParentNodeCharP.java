package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.holyshit.domain.Staff;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

public class ParentNodeCharP extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		String no = request.getParameter("node");
		
		ProjectStageSercvice pss = new ProjectStageServiceImpl();
		String pn = null;
		
		if(no.length()==6){
			pn = pss.getPMno(no);
		}
		else{
			String parno = pss.getPTaskNo(no);
			if(parno.length()==6){
				pn = pss.getStageChargePerson(parno);
			}
			else{
				pn = pss.getTaskChargePerson(parno);
			}
		}
		
		//不能选择pm为负责人
		/*String pno = no.substring(0,5);
		String pmno = pss.getPMno(pno);*/
		
		Staff staff = new Staff();
		StaffService ss = new StaffServiceImpl();
		staff = ss.findAStaff(pn);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", staff.getName());
		map.put("staffno", staff.getStaffno());
		
		String str = JSONObject.fromObject(map).toString();
		response.getWriter().write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
