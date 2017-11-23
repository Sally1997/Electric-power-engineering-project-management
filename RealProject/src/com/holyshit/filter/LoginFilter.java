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
import javax.servlet.http.HttpSession;
/**
 * 登陆拦截器 拦截转发界面
 * @author yuan
 *
 */
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String path = req.getRequestURI();
		//检查用户是否已经登陆
		HttpSession session=req.getSession();
		if(session.getAttribute("staff")!=null){
			
			chain.doFilter(request, response);
		}else{
			
			//没登录
			//直接界面登陆
			if(path.indexOf("/login.jsp")!=-1){
				System.out.println("path:  "+path);
				chain.doFilter(request, response);
			}
			//其他页面转发
			else {
				
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
