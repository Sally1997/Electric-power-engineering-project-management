package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Project;
import com.holyshit.domain.StageTask;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class MainServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取当前用户的项目列表
				List<Project> projects;
				ProjectService ps=new ProjectServiceImpl();
				String staffno=(String) request.getAttribute("staffno");
				projects=ps.findAllProjectsById(staffno);
				System.out.println();
				//获取当前用户的任务列表
				List<StageTask> tasks;
				StageTasksService sts=new StageTasksServiceImpl();
				tasks=sts.findAllTasksByid(staffno);
				
				if(projects!=null){
					request.setAttribute("projects", projects);
					request.setAttribute("projectSize", projects.size());
				}
				
				if(tasks!=null){
					request.setAttribute("tasks", tasks);
					request.setAttribute("taskSize", tasks.size());
				}
				
				//转向到主页
				request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
