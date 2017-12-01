package com.holyshit.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Project;
import com.holyshit.domain.PSPlan;
import com.holyshit.domain.StageTask;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;

import net.sf.json.JSONObject;

public class ShowNodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//获取
		String no = request.getParameter("NodeNo");
		
		//新建四个对象
		Project p = new Project();
		PSPlan ps = new PSPlan();
		StageTask st = new StageTask();
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		
		//返回
		String s = "";
		int len = no.length();

		try {
			if (len == 5) {
				p = dtns.GetProjectInfo(no);
				s = "项目,"+p.getPno()+","+p.getPname()+","+p.getPmno()+","+p.getStime()+","+p.getEtime()+","+p.getPbudget();
			}
			else if(len==6){
				ps = dtns.GetStageInfo(no);
				s = "项目阶段,"+ps.getStageNo()+","+ps.getSName()+","+ps.getCharPNo()+","+ps.getSTime()+","+ps.getETime()+","+"2200"+",我不知道";
			}
			else{
				st = dtns.GetTaskInfo(no);
				s = "任务节点,"+st.getTaskno()+","+st.getTaskname()+","+st.getCharpno()+","+st.getStime()+","+st.getEtime()+","+"2200"+",我不知道";
			}
			response.getWriter().write(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
