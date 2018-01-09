package com.holyshit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.holyshit.domain.Inform;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.impl.ProjectStageServiceImpl;

public class SubmitTaskServlet extends HttpServlet {
	
	//创建链表保存表单数据
	List<Map<String,Object>> list_1 = new ArrayList<Map<String,Object>>();
	Map<String,Object> form_map = new HashMap<String,Object>();
	List<String> upload_list = new ArrayList<String>();//文件路径
	int k = 0;
	List<String> info_list = new ArrayList<String>();//指标内容
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		//处理表单数据
		boolean ismpc = ServletFileUpload.isMultipartContent(request);
		if(!ismpc){
			System.out.println("enctype不是multipart/form-data格式");
		}
		
		//保存阶段或者任务的值
		String no = null;
		String cpn = "";
		String pn = null;//publisher no
		Inform info = new Inform();
		String pno = request.getParameter("pno");
		
		//创建一个本地目录
		String directorypath = "D:\\RealProject\\Index";
		//新建文件夹
		File store_directory = new File(directorypath);
		if(!store_directory.exists()){
			store_directory.mkdirs();
		}
		
		//新建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建解析对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		List<FileItem> list;
		
		try {
			list = sfu.parseRequest(request);
			for(FileItem fileitem:list){
				if(fileitem.isFormField()){//普通表单文件
					String name = fileitem.getFieldName();
					String value = new String(fileitem.getString().getBytes("ISO-8859-1"),"UTF-8");//必须！！！
					
					if(name.equals("ftask_no")){
						no = value;
					}
					else if(name.equals("fchar_per")){
						for(int i=0;i<12;i++){
							cpn+=value.charAt(value.length()-13+i);
						}
					}
					else if(name.equals("index")){
						info_list.add(value);
					}
				}
				else{//上传文件
					String filename = fileitem.getName();
					
					//文件路径值
					String path = directorypath;
					if(filename==""){
						path = null;
					}
					else{
						filename = UUID.randomUUID().toString() + "_" + filename;
						String code = Integer.toHexString(filename.hashCode());
						path += File.separator + code.charAt(0) + File.separator + code.charAt(1);
						File file = new File(path);
						if(!file.exists()){
							file.mkdirs();
						}
						
						try {
							fileitem.write(new File(path,filename));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						path += File.separator + filename;
						upload_list.add(path);
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProjectStageSercvice pss = new ProjectStageServiceImpl();
		if(no.length()==6){
			info.setMtype("A8");
			pn = pss.getPMno(no);
		}
		else{
			info.setMtype("A5");
			String parno = pss.getPTaskNo(no);
			if(parno.length()==6){
				pn = pss.getStageChargePerson(parno);
			}
			else{
				pn = pss.getTaskChargePerson(parno);
			}
		}
		info.setBusno(no);
		info.setSrcpno(cpn);
		info.setDstpno(pn);
		
		pss.submitTask(no, upload_list, info_list, info);
		
		//提交完成啦~跳回树状图把
		response.getWriter().write("<script type='text/javascript'>alert('新建成功!')</script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/servlet/DTreeNodeServlet?pno="+pno);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
