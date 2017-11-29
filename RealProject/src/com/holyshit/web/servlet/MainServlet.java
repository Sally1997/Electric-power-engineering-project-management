package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DocumentService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.DocumentServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取当前用户的项目列表
				List<Project> projects;
				ProjectService ps=new ProjectServiceImpl();
				String staffno=((Staff) request.getSession().getAttribute("staff")).getStaffno();
				projects=ps.findAllProjectsById(staffno);
				System.out.println();
				//获取当前用户的任务列表
				List<StageTask> tasks;
				StageTasksService sts=new StageTasksServiceImpl();
				tasks=sts.findAllTasksByid(staffno);
				
				//获取用户的文档信息
				DocumentService ds=new DocumentServiceImpl();
				Map<String, Object> staffDoc = ds.findDocumentWithUserById(staffno, 1, 10);

				//放入文档信息
				request.setAttribute("staffDoc", staffDoc);
				//放入用户项目信息
				if(projects!=null){
					request.setAttribute("projects", projects);
					
				}
				//放入用户项目任务
				if(tasks!=null){
					request.setAttribute("tasks", tasks);
				
				}
				
				//转向到主页
				request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
