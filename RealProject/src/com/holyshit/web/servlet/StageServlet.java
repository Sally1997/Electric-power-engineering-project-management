package com.holyshit.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.PlanManageService;
import com.holyshit.service.impl.PlanManageServiceImpl;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet({ "/StageServlet", "/servlet/StageServlet" })
public class StageServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		ProjectStage pro_stage = new ProjectStage();
		TaskIndexs task_index = new TaskIndexs();
		
		try {
			/**
			 * 获取表单数据
			 */
			//getParameterMap用不了，以后再说
			pro_stage.setStageName(request.getParameter("StageName"));
			//日期转换
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			pro_stage.setStartDate(sdf.parse(request.getParameter("StartDate")));
			pro_stage.setEndDate(sdf.parse(request.getParameter("EndDate")));
			
			//阶段编号（7），发布（12），负责人（12）null
			//指标编号（11），任务编号（10）null
			pro_stage.setStageNo("2015260");
			pro_stage.setProjectNo("10429");
			pro_stage.setPublisherNo("201526010429");
			pro_stage.setChargePerNo("201526010430");
			
			task_index.setIndexNo("15111214725");
			task_index.setTaskNo("1142265151");
			//指标
			task_index.setIndexInfo(request.getParameter("IndexInfo"));
			
			System.out.println(pro_stage);
			System.out.println(task_index);
			/**
			 * 处理业务逻辑
			 */
			//新建阶段
			PlanManageService pms = new PlanManageServiceImpl();
			pms.NewStage(pro_stage, task_index);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向
		/*response.getWriter().print("<script>新建成功！</script>");*/
//		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/PlanManagement_NewMilestone.jsp");
//	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
