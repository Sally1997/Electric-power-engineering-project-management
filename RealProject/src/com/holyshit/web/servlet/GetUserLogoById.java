package com.holyshit.web.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

public class GetUserLogoById extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		//����service����
		AccountService as=new AccountServiceImpl();
//		String res=as.getUserLogoLinkById(id);
		Staff staff=as.getUserById(id);
		//�������
		OutputStream out= response.getOutputStream();
		
		InputStream in=new FileInputStream(staff.getImagelink());
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=in.read(buffer))!=-1){
			
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();	
	}

}
