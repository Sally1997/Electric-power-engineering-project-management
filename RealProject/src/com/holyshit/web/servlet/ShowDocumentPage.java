package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.domain.Document;
import com.holyshit.domain.Staff;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class ShowDocumentPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		Staff staff=(Staff)request.getSession().getAttribute("staff");
		//调用服务
		DocumentService ds=new DocumentServiceImpl();
		Map<String, Object> res = ds.findDocumentWithUserById(staff.getStaffno(), cur, pageSize);
		JSONArray docs=new JSONArray();
		for(Document doc:(List<Document>)res.get("docs")){
			JSONObject json=new JSONObject();
			json.put("dtitle", doc.getDtitle());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			json.put("uploadtime", sdf.format(new Date(doc.getUploadtime().getTime())));
			json.put("uloadpno", doc.getUloadpno());
			json.put("fsize", doc.getFsize());
			json.put("ftype", doc.getFtype());
			json.put("dno", doc.getDno());
			docs.add(json);
		}
		
//		返回的结果集封装
		JSONObject jsondata=new JSONObject();
		jsondata.put("totalNum", res.get("totalNum"));
		jsondata.put("pageNum", res.get("pageNum"));
		jsondata.put("currentPage", res.get("currentPage"));
		jsondata.put("pageSize", res.get("pageSize"));
		jsondata.put("documentlist", docs);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsondata.toString());
	}

}
