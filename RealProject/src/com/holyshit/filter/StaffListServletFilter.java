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

public class StaffListServletFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resq=(HttpServletResponse) response;
		//获取数据
		String pno=(String) req.getParameter("pno");
		
		//获取session中的staff
		Staff staff=(Staff) req.getSession().getAttribute("staff");
		if(staff==null||pno==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		PermissionService ps=new PermissionServiceImpl();
		boolean hehe = ps.enableDeleteAndAddStaff(staff.getStaffno(), pno);
		if(hehe){
			request.setAttribute("deleteAndAddStaff", "1");
			chain.doFilter(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
		
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
