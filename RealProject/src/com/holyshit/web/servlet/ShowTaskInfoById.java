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

import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.TaskInfo;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class ShowTaskInfoById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		Staff staff=(Staff)request.getSession().getAttribute("staff");
		if(staff==null){
			System.out.println("session staff error");
			return;
		}
		
		//调用服务
		StageTasksService sts=new StageTasksServiceImpl();
		Map<String, Object> res = sts.showTaskInfoByPage(staff.getStaffno(), cur, pageSize);
		JSONArray docs=new JSONArray();
		for(TaskInfo doc:(List<TaskInfo>)res.get("tasks")){
			JSONObject json=new JSONObject();
			json.put("pname", doc.getPname());
			
			json.put("taskname", doc.getTaskname());
			
			json.put("stime", doc.getStime().toString());
			json.put("etime", doc.getEtime().toString());
			json.put("tstate",doc.getTstate() );
			json.put("pno", doc.getPno());
			json.put("taskno", doc.getTaskno());
			docs.add(json);
		}
		
//		返回的结果集封装
		JSONObject jsondata=new JSONObject();
		jsondata.put("totalNum", res.get("totalNum"));
		jsondata.put("pageNum", res.get("pageNum"));
		jsondata.put("currentPage", res.get("currentPage"));
		jsondata.put("pageSize", res.get("pageSize"));
		jsondata.put("tasklist", docs);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsondata.toString());
	}

}
