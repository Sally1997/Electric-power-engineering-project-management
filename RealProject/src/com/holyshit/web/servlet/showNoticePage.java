package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.domain.Notice;
import com.holyshit.service.NoticeService;
import com.holyshit.service.impl.NoticeServiceImpl;

public class showNoticePage extends HttpServlet {

	/**
	 * 用于ajax请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据
		int cur=Integer.parseInt(request.getParameter("currentPage"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		
		//调用服务
		NoticeService ns=new NoticeServiceImpl();
		Map<String, Object> res = ns.showAllNoticeByPage(cur, pageSize);
		
		//封装json
		JSONObject jsondata=new JSONObject();
		jsondata.put("totalNum", res.get("totalNum"));
		jsondata.put("pageNum", res.get("pageNum"));
		jsondata.put("currentPage", res.get("currentPage"));
		jsondata.put("pageSize", res.get("pageSize"));
		List<Notice> noticelist= (List<Notice>) res.get("noticelist");
		JSONArray list=JSONArray.fromObject(noticelist);
		System.out.println(list.toString());
		jsondata.put("noticelist", list.toString());
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsondata.toString());
		
	}

}
