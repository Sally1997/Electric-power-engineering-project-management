package com.holyshit.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.input.ReaderInputStream;

import com.holyshit.Dao.NoticeDao;
import com.holyshit.domain.Staff;
import com.holyshit.service.NoticeService;
import com.holyshit.service.impl.NoticeServiceImpl;

public class UploadNotice extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		/**
		 * cesium
		 */
		
		//处理上传的文件
		DiskFileItemFactory dff=new DiskFileItemFactory();
		dff.setRepository(new File(getServletContext().getRealPath("/tmp")));
		String realPath = "/var/ProjectData/ProjectNotice/"+new Date(new java.util.Date().getTime()).toString();
		System.out.println(realPath);
		File path=new File(realPath);
		path.setWritable(true, false);
		File last=null;
		
		//设置上传单个文件的大小
		ServletFileUpload fileUpload=new ServletFileUpload(dff);
		//设置最大为1M
		fileUpload.setFileSizeMax(1024*1024);
		System.out.println("上传文件啦");
		if(fileUpload.isMultipartContent(request)){
			List<FileItem> filelist=null;
			String title=null;
			String filename=null;
			String filepath=null;
		
			String uuid=UUID.randomUUID().toString();
			try {
				try {
					filelist = fileUpload.parseRequest(request);
				} catch (FileUploadBase.FileSizeLimitExceededException hehe) {
					// TODO Auto-generated catch block
					//返回错误信息
					System.out.println("文件大小超过限制");
					response.getWriter().write("上传文件最大为1M");
					return;
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			//处理
			for(FileItem item:filelist){
				if(item.isFormField()){
					title=new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(item.getFieldName()+":"+title);
				}else{
					//处理文件
					if(!path.exists())
						path.mkdirs();
					
					//文件名不重要
//					filename=item.getName();
//					filename=filename.substring(filename.lastIndexOf(File.separator)+1);
					filepath=path+File.separator+uuid+".html";
					try {
						
						last = new File(path,uuid+".html");
						System.out.println("最终路径为"+last.toString());
						last.setWritable(true,false);
						item.write(last);
						item.delete();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			//对于文件内容进行过滤
			boolean errorFlag=false;
			InputStreamReader inputStreamReader=new FileReader(last);
			int len=0;
			char [] buf=new char[1024];
			while((len=inputStreamReader.read(buf))!=-1){
				String key=String.valueOf(buf);
				if((key.indexOf("script")!=-1)||(key.indexOf("eval")!=-1)){
					errorFlag=true;
					break;
				}
			}
			if(errorFlag){
				response.getWriter().write("发布失败,请勿包含敏感性关键字");
				return;
			}
			//调用服务
			NoticeService ns=new NoticeServiceImpl();
			int res = ns.publishNotice(uuid,title, filepath, ((Staff)request.getSession().getAttribute("staff")).getStaffno(), new Date(new java.util.Date().getTime()));
			if(res==1)
				response.getWriter().write("ok");
			else {
				response.getWriter().write("发布失败");
			}
		}else {
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
		}
	}

}
