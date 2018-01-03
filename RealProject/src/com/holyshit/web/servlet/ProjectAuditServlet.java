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
import com.holyshit.domain.Staff;
import com.holyshit.service.AuditService;
import com.holyshit.service.InformService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

public class ProjectAuditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Inform info = new Inform();
		Projaprlaudit paa1 = new Projaprlaudit();//从数据取出来的
		Projaprlaudit paa2 = new Projaprlaudit();//插入下一审核人立项消息
		PSRelation psr = new PSRelation();
		
		String mno = request.getParameter("mno");
		String aev = request.getParameter("agree");
		String ai = request.getParameter("auditinfo");
		String pc = request.getParameter("PersonInCharge");
		
		if(aev.equals("agree")){
			aev="1";
		}
		else{
			aev="2";
		}
		
		String cpn = "";
		for(int i=0;i<12;i++){
			cpn+=pc.charAt(pc.length()-13+i);
		}
		
		
		AuditService as = new AuditServiceImpl();
		as.changePAAInfo(mno, aev, ai, cpn);
		//得到更改后的paa
		paa1 = as.getPAAInfoByMno(mno);
		
		StaffService ss = new StaffServiceImpl();
		if(!ss.ifInProject(cpn)){
			psr.setStaffno(cpn);
			psr.setPno(paa1.getPno());
			psr.setDuty("负责人");
			ss.addAStaff(psr);
		}
		
		if(pc!=null){//有下一审核人的情况下，给审核人发送信息和立项审核表
			
			paa2.setPno(paa1.getPno());
			paa2.setApplicantno(paa1.getApplicantno());
			paa2.setAuditorno(cpn);
			paa2.setAuditstate("0");
			
			as.addProAuditInfo(paa2);
			
			//处理消息表的业务逻辑
			InformService infoser = new InformServiceImpl();
			info.setBusno(infoser.getNewPaauditNo());
			
			info.setSrcpno(paa1.getAuditorno());
			info.setDstpno(paa1.getNauditorno());
			info.setMtype("3");
			info.setHasread("0");
			
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			info.setMdate(ts);
			
			infoser.addInform(info);
		}
		
		//跳转到消息界面？？？？
		//request.getRequestDispatcher("/")
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
