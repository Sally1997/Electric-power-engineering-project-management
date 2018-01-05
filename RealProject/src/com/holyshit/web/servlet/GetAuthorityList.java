package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.holyshit.Dao.AuthorityDao;
import com.holyshit.Dao.impl.AuthorityDaoImpl;
import com.holyshit.domain.Authority;
import com.holyshit.service.AuthorityService;
import com.holyshit.service.impl.AuthorityServiceImpl;

public class GetAuthorityList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String staffno=request.getParameter("staffno");
		if(staffno==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		
		//获取信息
		AuthorityService as=new AuthorityServiceImpl();
		List<Authority> allAuthority = as.findAllAuthority();
		List<Authority> hasAuthority = as.findAuthorityById(staffno);
		Map<Integer, String> set=new HashMap<Integer, String>();
		//取得已有的权限
		for(Authority a:hasAuthority){
			set.put(a.getPerno(), a.getPername());
		}
		//封装json返回值
		JSONArray ja=new JSONArray();
		for(Authority a:allAuthority){
			JSONObject jo=new JSONObject();
			jo.put("perno", a.getPerno());
			jo.put("pername", a.getPername());
			if(set.get(a.getPerno())!=null){
				jo.put("has", 1);
			}else {
				jo.put("has", 0);
			}
			ja.add(jo);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(ja.toString());
	}

}
