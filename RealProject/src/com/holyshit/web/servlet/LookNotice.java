package com.holyshit.web.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Notice;
import com.holyshit.service.NoticeService;
import com.holyshit.service.impl.NoticeServiceImpl;

public class LookNotice extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String noticeno=request.getParameter("noticeno");
		if(noticeno==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
		}
		
		//读取文件内容并且压入request
		NoticeService ns=new NoticeServiceImpl();
		Notice notice = ns.findNoticeById(noticeno);
		//
		String noticetitle=notice.getNoticetitle();
		Date pubtime = notice.getPubtime();
		String filepath=notice.getFilepath();
		String noticecontent="";
		System.out.println(filepath);
		//读取文件内容 字符流
		InputStreamReader input=new FileReader(filepath);
		
		char buffer[]=new char[512];
		int len=0;
		while((len=input.read(buffer))!=-1){
			noticecontent+=new String(buffer, 0, len);
		}
		
		//关闭输入流
		input.close();
		//压入数据，分发转向
		request.setAttribute("noticetitle", noticetitle);
		request.setAttribute("noticecontent", noticecontent);
		request.setAttribute("pubtime", new Timestamp(pubtime.getTime()));
		request.getRequestDispatcher("/jsp/homeManage/notice.jsp").forward(request, response);;
	}

}
