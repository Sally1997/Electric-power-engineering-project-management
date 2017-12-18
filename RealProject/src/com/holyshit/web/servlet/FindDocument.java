package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class FindDocument extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	参数	dtype="+dType+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&keywords="+keywords+"&ftype="+fType+"&currentPage="+cur+"&pageSize="+pagesize);
		String dtype=request.getParameter("dtype");
		String dateFrom=request.getParameter("dateFrom");
		String dateTo=request.getParameter("dateTo");
		String keywords=request.getParameter("keywords");
		String ftype=request.getParameter("ftype");
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		if(dtype==null||dateFrom==null||dateTo==null||keywords==null||ftype==null){
			//返回
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		//调用服务
		DocumentService ds=new DocumentServiceImpl();
		Map<String, Object> res = ds.findDocumentByContidtion(dtype, dateFrom, dateTo, keywords, ftype, cur, pageSize);
	
		JSONObject json=new JSONObject();
		json.put("totalNum", res.get("totalNum"));
		json.put("docs", res.get("docs"));
		json.put("pageSize", res.get("pageSize"));
		json.put("currentPage", res.get("currentPage"));
		json.put("pageNum", res.get("pageNum"));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
	}

}
