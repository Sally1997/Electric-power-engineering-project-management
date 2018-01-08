package com.holyshit.web.servlet;

import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Document;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class DownLoadIndex extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path=request.getParameter("dno");
		System.out.println(path);
		System.out.println("??");
		/*if(path==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		//设置文件的编码
		if(request.getHeader("user-agent").toLowerCase().contains("msie")){
			filename = URLEncoder.encode(filename,"UTF-8");//将不安全的文件改成UTF-8格式
		}
		else{
			filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");//火狐浏览器
		}
		
		response.setHeader("content-disposition", "attachment;filename=" +filename);
		InputStream input=new FileInputStream(path);
		OutputStream out=response.getOutputStream();
		int len=0;
	
		//缓冲区
		byte b[]=new byte[1024];
		while((len=input.read(b))!=-1){
			out.write(b, 0, len);
		}
		//关闭流
		out.close();
		input.close();*/
	}

}
