package com.holyshit.web.servlet;

import java.io.IOException;
<<<<<<< HEAD
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet({ "/StageServlet", "/servlet/StageServlet" })
public class StageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
=======
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.Staff;
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
			
			//ss.getAttribute
			HttpSession session = request.getSession();
			Staff staff = (Staff)session.getAttribute("staff");
			
			//阶段编号（7），发布（12），负责人（12）null
			//指标编号（11），任务编号（10）null
			pro_stage.setStageNo("2015262");
			pro_stage.setProjectNo("10423");
			pro_stage.setPublisherNo(staff.getStaffno());//发布人
			pro_stage.setChargePerNo("20152601043g");
			
			task_index.setIndexNo("1511121472g");
			task_index.setTaskNo("114226515g");
			
			
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
		response.getWriter().print("<script>新建成功！</script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/PlanManagement_NewMilestone.jsp");
//	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
		doGet(request, response);
	}

}
