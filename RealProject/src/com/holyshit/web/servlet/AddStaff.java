package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javassist.compiler.ast.Variable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;
import com.holyshit.utils.MD5Util;

public class AddStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Staff newStaff=new Staff();
		newStaff.setStaffno(request.getParameter("staffno"));
		String name=request.getParameter("name");
		newStaff.setName(name);
		String sex=request.getParameter("sex");
		newStaff.setSex(sex);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sdf.parse(request.getParameter("birthday"));
			newStaff.setBirthday(new java.sql.Date(parse.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("出生日期异常!");
			return;
		}
		newStaff.setTe(request.getParameter("te"));
		newStaff.setEmail(request.getParameter("email"));
		String password=request.getParameter("password");
		//对字符串进行md5加密
		String md5_password = MD5Util.md5(password);
		StaffService ss=new StaffServiceImpl();
		boolean res = ss.addStaffByRoot(newStaff, md5_password);
		if(res){
			response.getWriter().write("ok");
		}else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("添加失败,编号可能重复或是服务器繁忙");
		}
		//
	}

}
