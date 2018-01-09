package com.holyshit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.holyshit.domain.Document;
import com.holyshit.domain.Inform;
import com.holyshit.domain.PDocAudit;
import com.holyshit.domain.PSRelation;
import com.holyshit.domain.Projaprlaudit;
import com.holyshit.domain.Project;
import com.holyshit.domain.Staff;
import com.holyshit.service.AuditService;
import com.holyshit.service.DocumentService;
import com.holyshit.service.InformService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.AuditServiceImpl;
import com.holyshit.service.impl.DocumentServiceImpl;
import com.holyshit.service.impl.InformServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;
import com.holyshit.utils.AutoNumber;

@WebServlet({ "/NewProjectServlet", "/servlet/NewProjectServlet" })
public class NewProjectServlet extends HttpServlet {
	//新建项目插入的表有：项目表，立项审核表，项目文档审核表，文档表,消息表
	Project pro = new Project();
	Projaprlaudit paa = new Projaprlaudit();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Inform info = new Inform();
	Document doc = new Document();
	PDocAudit pda = new PDocAudit();
	PSRelation psr = new PSRelation();
	
	//这条消息是插这个项目管理的
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		//处理表单数据
		boolean ismpc = ServletFileUpload.isMultipartContent(request);
		if(!ismpc){
			System.out.println("enctype不是multipart/form-data格式");
			return;
		}
		
		//新建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建解析对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		
		List<FileItem> list;
		try {
			list = sfu.parseRequest(request);
			for(FileItem fileitem:list){
				if(fileitem.isFormField()){
					//普通表单
					processFormField(fileitem);
				}
				else{
					//上传文件
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//处理业务逻辑
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		String staffno = staff.getStaffno();
		
		pro.setPmno(staffno);
		paa.setApplicantno(staffno);//申请人编号1
		pda.setApplicantno(staffno);
		doc.setUloadpno(staffno);//doc 2
		psr.setStaffno(staffno);
		
		//项目阶段初始化为立项中
		pro.setPstate("0");
		//阶段初始化为0
		pro.setPstage(0);
		
		//初始化审核状态
		paa.setAuditstate("0");
		pda.setAuditstate("0");
		
		ProjectService ps = new ProjectServiceImpl();//1
		ps.NewProject(pro);
		
		//因为项目审核的主键是自增长数列，所以必须先插入paa，才能得到他的最新的主键
		AuditService as = new AuditServiceImpl();//2
		as.addProAuditInfo(paa);
		
		//处理消息表的业务逻辑
		InformService infoser = new InformServiceImpl();
		info.setBusno(infoser.getNewPaauditNo());
		info.setSrcpno(staffno);
		info.setMtype("A11");
		info.setHasread("0");
		//设置时间戳，mdate取名错了，应该是mtime
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setMdate(ts);
		doc.setUploadtime(ts);//文档上传时间
		
		doc.setDloadtimes(0);
		doc.setAuditres("0");
		
		psr.setDuty("项目经理");
		/*DocumentService ds = new DocumentServiceImpl();
		boolean bool = ds.addDocument(doc);//4
		if(!bool){
			response.getWriter().write("<script type='text/javascript'>alert('服务器繁忙……上传失败!')</script>");
		}*/
		
		ps.newPeojectManage(pro, psr, info, doc, pda);
		response.getWriter().write("<script type='text/javascript'>alert('新建成功!')</script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/servlet/ShowProjectServlet");
	}
	
	//上传文件处理
	private void processUploadField(FileItem fileitem) {
		String filename = fileitem.getName();
		String suffix = filename.substring(filename.lastIndexOf('.')+1);
		String fname = filename.substring(filename.lastIndexOf(File.separator)+1, filename.lastIndexOf('.'));
		String path = new String();
		doc.setDtitle(fname);
		doc.setFtype(suffix);
		
		doc.setDtype("3");//文件类型是使用文档
		doc.setFsize((int) fileitem.getSize());//doc 8
		
		if(filename.equals("")){
			path = null;
		}
		else{
			//解决同名问题
			String uu = UUID.randomUUID().toString();
			doc.setDno(uu);//doc 1
			pda.setPdocno(uu);
			
			filename = uu +"_"+ filename;
			
			//创建一个本地目录 directory path 目录路径
			 String dp = File.separator + "var" + File.separator + "ProjectData" + File.separator + "ProjectFile";
			
			//新建文件夹 store directory 存储路径
			File sd = new File(dp);
			if(!sd.exists()){
				sd.mkdirs();
			}
			
			//打散目录
			String cdp = makeDirectoryPath(sd,filename);
			path = dp + File.separator + cdp + File.separator + filename;
			doc.setDpath(path);
			
			try {
				fileitem.write(new File(dp,cdp+File.separator+filename));
				fileitem.delete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String makeDirectoryPath(File dp, String filename) {
		int hashcode = filename.hashCode();
		String code = Integer.toHexString(hashcode);
		String cdp = code.charAt(0) + File.separator + code.charAt(1);
		File file = new File(dp,cdp);
		if(!file.exists()){
			file.mkdirs();
		}
		return cdp;
	}

	private void processFormField(FileItem fileitem) throws ParseException {
		//获取属性值name
		String filename = fileitem.getFieldName();
		//获取value值
		String filevalue=null;
		try {
			filevalue = new String(fileitem.getString().getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(filename+"="+filevalue);
		//表单逻辑处理
		
		
		if(filename.equals("ProjectName")){
			pro.setPname(filevalue);
		}
		else if(filename.equals("ProjectType")){
			String x;
			if(filevalue.equals("工程类")){
				x="1";
			}
			else{
				x="0";
			}
			pro.setPtype(x);
			
			//根据项目类型生成项目编号
			AutoNumber au = new AutoNumber();
			String pno = au.PTypeToPNo(x);
			pro.setPno(pno);
			paa.setPno(pno);//设置项目编号3
			pda.setPno(pno);
			doc.setPno(pno);//doc 3 设置项目编号
			psr.setPno(pno);
		}
		else if(filename.equals("PersonInCharge")){
			String cpn = "";
			for(int i=0;i<12;i++){
				cpn+=filevalue.charAt(filevalue.length()-13+i);
			}
			pro.setPmno(cpn);
			paa.setAuditorno(cpn);//设置审核人编号 2
			pda.setAuditorno(cpn);
			info.setDstpno(cpn);
		}
		else if(filename.equals("ProjectBudget")){
			double bg = Double.parseDouble(filevalue);
			pro.setPbudget(bg);
		}
		else if(filename.equals("stime")){
			java.util.Date d= sdf.parse(filevalue);
			java.sql.Date date = new java.sql.Date(d.getTime());
			pro.setStime(date);
		}
		else{
			java.util.Date d= sdf.parse(filevalue);
			java.sql.Date date = new java.sql.Date(d.getTime());
			pro.setEtime(date);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
