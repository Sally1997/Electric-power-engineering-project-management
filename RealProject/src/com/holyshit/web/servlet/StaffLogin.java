package com.holyshit.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.Account;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.service.AccountService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.AccountServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;

public class StaffLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//��ȡ��
		Account account=new Account();
		try {
			BeanUtils.populate(account, request.getParameterMap());
			account.setLltime(new Date(new java.util.Date().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code=request.getParameter("validatecode");
		//�Ƿ��½�ɹ�
		AccountService as=new AccountServiceImpl();
		boolean res=false;
		Map<String, String> error=new HashMap<String, String>();
		HttpSession session = request.getSession();

		if(code.equals(session.getAttribute("validatecode"))){
			if(as.login(account)){
				res=true;
			
			}
			else {
			
				error.put("username", "用户名或者密码错误");
			}
		}else {
		
			error.put("validatecode", "验证码错误");
		}	
		//�ַ�ת��
		if(res){

			//����session
			session.removeAttribute("validatecode");
			//获取用户的信息
			Staff staff = as.getUserById(account.getStaffno());
			session.setAttribute("staff", staff);
			//跳转到相应的uri
			String uri=request.getParameter("uri");
			if(uri!=null){
				//跳入相应的界面
				response.sendRedirect(uri);
			}
			else {
				//进入主页
				request.setAttribute("staffno", account.getStaffno());
				request.getRequestDispatcher("/web/servlet/mainServlet").forward(request, response);
			}
		}else{
		
			request.setAttribute("error", error);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
