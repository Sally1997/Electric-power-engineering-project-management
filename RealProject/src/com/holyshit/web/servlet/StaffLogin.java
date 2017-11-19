package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.holyshit.domain.Account;
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

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
			
				error.put("username", "�û��������������");
			}
		}else {
		
			error.put("validatecode", "��֤�����");
		}	
		//�ַ�ת��
		if(res){
			//����session
			session.removeAttribute("validatecode");
			session.setAttribute("account", account);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("��½�ɹ�");
			//cookie
			//��ת��ҳ
		}else{
		
			request.setAttribute("error", error);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	System.out.println("��½���̽���");
	}

}
