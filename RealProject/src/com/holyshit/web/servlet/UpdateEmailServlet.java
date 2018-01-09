package com.holyshit.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Authority;
import com.holyshit.domain.Qualification;
import com.holyshit.domain.Staff;
import com.holyshit.service.AuthorityService;
import com.holyshit.service.QualificationService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.AuthorityServiceImpl;
import com.holyshit.service.impl.QualificationServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

/**
 * Servlet implementation class UpdateEmailServlet
 */
@WebServlet("/web/servlet/updateEmailServlet")
public class UpdateEmailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffno = ((Staff) request.getSession().getAttribute("staff")).getStaffno();
		String email=request.getParameter("email");
		String error1="";
		StaffService ss = new StaffServiceImpl();
		QualificationService qfs = new QualificationServiceImpl();
		int flag=0;
		int flag2=0; 
		int index=0;
		int index2=0;
		int count1=0;
		int count2=0;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='@')
			{
				flag=1;
				index=i;
				count1++;
			}
			if(email.charAt(i)=='.')
			{
				flag2=1;
				index2=i;
				count2++;
			}
			if(flag==1&&flag2==1)
			{
				break;
			}
		}
		if(flag==1&&flag2==1&&index>=5&&index2>=7&&index<index2&&count1==1&&count2==1)
		{
			ss.updateemail(staffno, email);
		}
		else
		{
			error1="您输入的邮箱格式不符合要求";
		}
		
		/*else {
			if(index==0)
			{
				error1="请输入格式正确的邮箱地址，@符号前需要有字母表示地址";
			}
			else {
				String houzhui=email.substring(index, email.length()-1);
				String[] a={"@gmail.com",
						"@yahoo.com",
						"@msn.com",
						"@hotmail.com",
						"@aol.com",
						"@ask.com",
						"@live.com",
						"@qq.com",
						"@0355.net",
						"@163.com",
						"@163.net",           
						"@263.net" ,                            
						"@3721.net" , 
						"@yeah.net",
						"@googlemail.com",
						"@mail.com"};
				int flag1=0;
				for(int i=0;i<a.length;i++)
				{
					if(houzhui==a[i])
					{
						flag1=1;
					}
				}
				if(flag1==0)
				{
					error1="您输入的邮箱的后缀名不是常用邮箱后缀名，不支持该邮箱";
				}
			}
		}*/
		AuthorityService as = new AuthorityServiceImpl();
		List<Authority> aList = as.findAuthorityById(staffno);
		String defaultauth = "";
		if(aList.isEmpty())
		{
			defaultauth = "无特殊权限";
			
		}
		request.setAttribute("defaultauth",defaultauth );
		Staff me = ss.findAStaff(staffno);
		request.setAttribute("aList",aList );
		List<Qualification> qL = qfs.findAllQualifications(staffno);
		request.setAttribute("error1",error1);
		request.setAttribute("me",me );
		request.setAttribute("qL",qL );
		request.getRequestDispatcher("/jsp/projectManage/UserCenter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
