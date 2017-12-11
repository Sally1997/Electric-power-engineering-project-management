package com.holyshit.web.servlet;

import java.io.File;
import java.io.FileInputStream;
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

public class DownLoadMessage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取文档id
		String dno=request.getParameter("dno");
		if(dno==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
		}
		
		DocumentService ds=new DocumentServiceImpl();
		Document doc = ds.findDocumentById(dno);
		if(doc==null){
			System.out.println("不存在啊");
			request.getRequestDispatcher("/jsp/error/error_404.jsp").forward(request, response);
		}
		String filepath=doc.getDpath();
		String filename=filepath.substring(filepath.lastIndexOf(File.separator)+1);
		filename=filename.substring(filename.lastIndexOf("_")+1);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		InputStream input=new FileInputStream(filepath);
		OutputStream out=response.getOutputStream();
		int len=0;
		//缓冲区
		byte b[]=new byte[1024];
		while((len=input.read(b))!=-1){
			out.write(b, 0, len);
		}
		
		//关闭流
		out.close();
		input.close();
	}

}
