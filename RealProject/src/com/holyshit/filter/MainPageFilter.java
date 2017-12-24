package com.holyshit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.PermissionService;
import com.holyshit.service.impl.PermissionServiceImpl;

public class MainPageFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		Staff staff=(Staff)req.getSession().getAttribute("staff");
		if(staff==null){
			request.setAttribute("locError", "请先登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
			
		//发布公告权限设置
		PermissionService ps=new PermissionServiceImpl();
		boolean res = ps.enablePublicNotice(staff.getStaffno());
		if(res){
			request.setAttribute("publicNotice_1", "ok");
			chain.doFilter(request, response);
		}else
			chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
