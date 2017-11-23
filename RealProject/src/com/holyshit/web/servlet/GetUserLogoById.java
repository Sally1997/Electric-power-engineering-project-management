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

<<<<<<< HEAD
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

public class GetUserLogoById extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		//µ÷ÓÃservice·½·¨
		AccountService as=new AccountServiceImpl();
		String res=as.getUserLogoLinkById(id);
		
		//·µ»ØÊý¾Ý
		OutputStream out= response.getOutputStream();
		
		InputStream in=new FileInputStream(res);
		int len=0;
		byte[] buffer=new byte[1024];
		OutputStream file=new FileOutputStream("d:/1.jpg");
		while((len=in.read(buffer))!=-1){
			
			out.write(buffer, 0, len);
			file.write(buffer,0,len);
		}
		
		in.close();
		out.close();
		file.close();
		System.out.println("¶ÁÈ¡Íê³É");
		
		
=======
import com.holyshit.domain.Staff;
import com.holyshit.service.AccountService;
import com.holyshit.service.impl.AccountServiceImpl;

public class GetUserLogoById extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		//ï¿½ï¿½ï¿½ï¿½serviceï¿½ï¿½ï¿½ï¿½
		AccountService as=new AccountServiceImpl();
//		String res=as.getUserLogoLinkById(id);
		Staff staff=as.getUserById(id);
		if(staff==null||staff.getImagelink()==null){
			response.setStatus(404);
			return;
		}
		//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
		OutputStream out= response.getOutputStream();
		
		InputStream in=new FileInputStream(staff.getImagelink());
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=in.read(buffer))!=-1){
			
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();	
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
	}

}
