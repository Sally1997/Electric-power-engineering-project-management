package com.holyshit.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Staff;
import com.holyshit.service.InformService;
import com.holyshit.service.impl.InformServiceImpl;

public class GetInformNumber implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session= request.getSession();
		Staff staff=(Staff)session.getAttribute("staff");
  		InformService is=new InformServiceImpl();
  		Map<String,Object> res=is.findInformNumber(staff.getStaffno());
  		
  		long task_num=(long)res.get("task_num");
  		long audit_num=(long)res.get("audit_num");
  		long system_num=(long)res.get("system_num");
  		//压入数值
  		session.setAttribute("task_num", task_num);
  		session.setAttribute("system_num", system_num);
  		session.setAttribute("audit_num", audit_num);
  		session.setAttribute("all_num", task_num+system_num+audit_num);
  		chain.doFilter(req,resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
