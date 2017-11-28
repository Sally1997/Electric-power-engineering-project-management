package com.holyshit.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.DTree;
import com.holyshit.domain.Project;
import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;

public class DTreeNodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//get form data;now use "10001" as project no
		//request.getAttribute("ProjectNo");
		String pn = "10001";
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		List<DTree> list = new ArrayList<DTree>();
		try {
			Project pro = dtns.GetProjectInfo(pn);
			List<ProjectStage> slist = dtns.GetSNByPn(pn);
			List<StageTask> tlist = dtns.GetTNByPn(pn);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
