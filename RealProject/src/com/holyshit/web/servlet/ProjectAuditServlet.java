package com.holyshit.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.Inform;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.service.AuditService;
import com.holyshit.service.DocumentService;
import com.holyshit.service.InformService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.DocumentServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

public class ProjectAuditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		//改变立项审核状态，插入下已审核的理想审核信息
		//给下一审核人发酵系，
		//如果立项成功，给项目经理发信息
		//改变项目状态
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		
		Inform info = new Inform();
		Projaprlaudit paa1 = new Projaprlaudit();//从数据取出来的
		Projaprlaudit paa2 = new Projaprlaudit();//插入下一审核人立项消息
		PSRelation psr = new PSRelation();
		
		//mno是理想审核表编号
		String mno = request.getParameter("mno");
		String aev = request.getParameter("agree");
		String ai = request.getParameter("auditinfo");
		String pc = request.getParameter("PersonInCharge");
		
		if(aev.equals("agree")){
			aev="2";
		}
		else{
			aev="1";
		}
		
		AuditService as = new AuditServiceImpl();
		ProjectService ps = new ProjectServiceImpl();
		InformService infoser = new InformServiceImpl();
		
		if(pc==""){
			as.changePAAInfo(mno, aev, ai);
			//得到更改后的paa
			paa1 = as.getPAAInfoByMno(mno);
			
			String pno = paa1.getPno();
			
			DocumentService ds = new DocumentServiceImpl();
			String dno = ds.getPDocNo(pno);
			
			if(aev=="2"){
				ds.changeDocAuditRes(aev, dno);
				
				aev = "y";
				
				ps.changeProjectState(pno, aev);
				
				Inform info1 = new Inform();
				//结束审批发送消息
				Project pro = ps.getProjectInfo(pno);
				info1.setDstpno(pro.getPmno());
				info1.setSrcpno(staff.getStaffno());
				info1.setMtype("A12");
				info1.setBusno(mno);
				
				infoser.addInform(info1);
			}
			else{
				ds.changeDocAuditRes(aev, dno);
				
				aev = "n";
				
				ps.changeProjectState(pno, aev);
				
				Inform info1 = new Inform();
				//结束审批发送消息
				Project pro = ps.getProjectInfo(pno);
				info1.setDstpno(pro.getPmno());
				info1.setSrcpno(staff.getStaffno());
				info1.setMtype("A13");
				info1.setBusno(mno);
				
				infoser.addInform(info1);
			}
		}
		else{
			String cpn = "";
			for(int i=0;i<12;i++){
				cpn+=pc.charAt(pc.length()-13+i);
			}
			
			as.changePAAInfo(mno, aev, ai, cpn);
			//得到更改后的paa
			paa1 = as.getPAAInfoByMno(mno);
			String pno = paa1.getPno();
			
			StaffService ss = new StaffServiceImpl();
			
			//psr表
			psr.setStaffno(cpn);
			psr.setPno(pno);
			psr.setDuty("负责人");
			if(!ss.selectIfInProject(pno, cpn)){
				ss.addAStaff(psr);
			}
			
			//有下一审核人的情况下，给审核人发送信息和立项审核表
				
			paa2.setPno(paa1.getPno());
			paa2.setApplicantno(paa1.getApplicantno());
			paa2.setAuditorno(cpn);
			paa2.setAuditstate("0");
			
			as.addProAuditInfo(paa2);
			
			//处理消息表的业务逻辑
			info.setBusno(infoser.getNewPaauditNo());
			
			info.setSrcpno(paa1.getAuditorno());
			info.setDstpno(paa1.getNauditorno());
			info.setMtype("A11");
			info.setHasread("0");
			
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			info.setMdate(ts);
			
			infoser.addInform(info);
		}
		
			
		//跳转到消息界面？？？？
		response.getWriter().write("<script type='text/javascript'>alert('审核成功!')</script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/web/servlet/shouInformServlet?type=1");
		//request.getRequestDispatcher("/")
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
