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
import com.holyshit.domain.PSPlan;
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
			List<PSPlan> slist = dtns.GetSNByPn(pn);
			List<StageTask> tlist = dtns.GetTNByPn(pn);
			
			//加入项目阶段节点
			DTree dt = new DTree();
			dt.setCurrentNode(pro.getPno());
			dt.setParentNode("-1");
			dt.setNodeName(pro.getPname());
			list.add(dt);
			
			//加入阶段节点
			for(int i=0;i<slist.size();i++){
				DTree dt1 = new DTree();
				dt1.setCurrentNode(slist.get(i).getStageNo());
				dt1.setParentNode(slist.get(i).getPNo());
				dt1.setNodeName(slist.get(i).getSName());
				list.add(dt1);
			}
			
			//加入任务节点
			for(int i=0;i<tlist.size();i++){
				DTree dt2 = new DTree();
				dt2.setCurrentNode(tlist.get(i).getTaskno());
				dt2.setParentNode(tlist.get(i).getPtaskno());
				dt2.setNodeName(tlist.get(i).getTaskname());
				list.add(dt2);
			}
			//String str = JSONArray.fromObject(list).toString();
//			//输出
//			response.getWriter().write(str);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/PlanManage/PlanManagement_Newed.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
