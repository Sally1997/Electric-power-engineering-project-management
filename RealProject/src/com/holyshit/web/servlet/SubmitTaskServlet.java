package com.holyshit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.holyshit.domain.PSRelation;
import com.holyshit.service.DTreeNodeService;
import com.holyshit.service.StaffService;
import com.holyshit.service.impl.DTreeNodeServiceImpl;
import com.holyshit.service.impl.StaffServiceImpl;

public class SubmitTaskServlet extends HttpServlet {
	
	//创建链表保存表单数据
	List<Map<String,Object>> list_1 = new ArrayList<Map<String,Object>>();
	Map<String,Object> form_map = new HashMap<String,Object>();
	List<String> upload_list = new ArrayList<String>();//文件路径
	int k = 0;
	List<String> info_list = new ArrayList<String>();//指标内容
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		//String pno = request.getParameter("pno");
		String pno = "10001";
		
		//处理表单数据
		boolean ismpc = ServletFileUpload.isMultipartContent(request);
		if(!ismpc){
			System.out.println("enctype不是multipart/form-data格式");
		}
		
		//新建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建一个解析对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> list = sfu.parseRequest(request);
			
			for(FileItem fileitem:list){
				if(fileitem.isFormField()){
					//普通表单
					processFormField(fileitem);
				}
				else{
					//文件上传
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//这里的业务逻辑：
		DTreeNodeService dtns = new DTreeNodeServiceImpl();
		
		//1.根据编号和指标名添加指标附件的路径
		int len = upload_list.size();
		String no = (String) form_map.get("ftask_no");
		//将map中
		for(int i=0;i<len;i++){
			dtns.addIndexPath(upload_list.get(i), no, info_list.get(i));
		}
		
		//2.更新阶段或者任务状态为1开始
		if(no.length()==6){
			//根据阶段和任务编号长度不同
			dtns.changeSState(no);
		}
		else{
			dtns.changeTState(no);
		}
		
		//3.如果提交的审核人并非此项目组人员，则将此人拉进关系表
		String rcpn = (String) form_map.get("fchar_per");
		String cpn = "";
		for(int i=0;i<12;i++){
			cpn+=rcpn.charAt(rcpn.length()-13+i);
		}
		StaffService ss = new StaffServiceImpl();
		if(!ss.ifInProject(cpn)){
			PSRelation psr = new PSRelation();
			psr.setStaffno(cpn);
			psr.setPno(pno);
			psr.setDuty("审核人");
			ss.addAStaff(psr);
		}
		
		//提交完成啦~跳回树状图把
		response.sendRedirect("/RealProject/servlet/DTreeNodeServlet?pno="+pno);
	}
	
	//上传文件处理
	private void processUploadField(FileItem fileitem) {
		//获取文件名
		String filename = fileitem.getName();
		String path = new String();
		if(filename.equals("")){
			//文件名为空的情况下
			path = null;
		}
		else{
			//解决同名情况
			filename = UUID.randomUUID()+"_"+filename;
			
			//创建一个本地目录
			String directorypath = "D:\\RealProject\\Upload";
			//新建文件夹
			File store_directory = new File(directorypath);
			if(!store_directory.exists()){
				store_directory.mkdirs();
			}
			
			//打散目录
			String child_directory_path = makeDirectoryPath(store_directory,filename);
			path = directorypath+File.separator+child_directory_path+File.separator+filename;
			
			try {
				//写入文件
				fileitem.write(new File(directorypath,child_directory_path+File.separator+filename));
				fileitem.delete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		upload_list.add(path);
		
	}
	
	//普通表单处理
	private void processFormField(FileItem fileitem) {
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
		//把表单结果封装到map里面
		if(k<3){
			form_map.put(filename,filevalue);
			k++;
		}
		else{
			info_list.add(filevalue);
		}
	}
	
	public String makeDirectoryPath(File store_directory,String filename){
		int hascode = filename.hashCode();//返回32位哈希编码
		String code = Integer.toHexString(hascode);//将哈希码转换为16进制字符
		String child_directory_path = code.charAt(0)+ File.separator + code.charAt(1);
		File file = new File(store_directory,child_directory_path);
		
		if(!file.exists()){
			file.mkdirs();
		}
		return child_directory_path;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
