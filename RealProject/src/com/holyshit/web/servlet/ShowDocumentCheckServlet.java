package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Document;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

/**
 * Servlet implementation class ShowDocumentCheckServlet
 */
public class ShowDocumentCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("documentcheckshow");
		DocumentService ds = new DocumentServiceImpl();
		List<Document> documents = ds.findallneededauditfile();
		System.out.println("LIST:"+documents.size());
		request.setAttribute("documents", documents);
		request.getRequestDispatcher("/jsp/documentManage/documentCheck.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
