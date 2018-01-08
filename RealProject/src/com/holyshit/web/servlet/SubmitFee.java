package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.TaskInfo;
import com.holyshit.service.MoneyManageService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.MoneyManageServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class SubmitFee extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取数据
		String taskno=request.getParameter("taskno");
		String task_feeaudit=request.getParameter("task_feeaudit");
		String fee_cause=request.getParameter("fee_cause");
		double fee=Double.parseDouble(task_feeaudit);
		//验证数据
		StageTasksService sts=new StageTasksServiceImpl();
		
		TaskInfo task=sts.findTaskInfoById(taskno);
		double hasused=sts.findUsedFeeByTaskno(task.getTaskno());
		double surplus=task.getBudget()-hasused;
		if(task==null||(fee>surplus && fee_cause.equals(""))){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			return;
		}
		MoneyManageService ms=new MoneyManageServiceImpl();
		int res=ms.handleFee(task, fee, fee_cause, fee>surplus?true:false);
		if(res==1){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("ok");
			return;
		}else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			return;
		}
		
	}

}
