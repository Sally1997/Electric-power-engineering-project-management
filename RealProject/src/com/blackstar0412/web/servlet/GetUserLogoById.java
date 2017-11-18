package com.blackstar0412.web.servlet;

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

import com.blackstar0412.service.AccountService;
import com.blackstar0412.service.impl.AccountServiceImpl;

public class GetUserLogoById extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		//调用service方法
		AccountService as=new AccountServiceImpl();
		String res=as.getUserLogoLinkById(id);
		
		//返回数据
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
		System.out.println("读取完成");
		
		
	}

}
