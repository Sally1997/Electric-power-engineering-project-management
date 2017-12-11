package com.holyshit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.holyshit.Dao.NoticeDao;
import com.holyshit.domain.Staff;
import com.holyshit.service.NoticeService;
import com.holyshit.service.impl.NoticeServiceImpl;

public class UploadNotice extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		//处理上传的文件
		DiskFileItemFactory dff=new DiskFileItemFactory();
		File path=new File(request.getServletContext().getRealPath("/upload"));
		//设置临时文件存储路径
		dff.setRepository(new File(getServletContext().getRealPath("/tmp")));
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
					filename=item.getName();
					filepath=path.toString()+File.separator+filename;
					System.out.println("文件名:"+filename);
					try {
						item.write(new File(path+File.separator+filename));
						item.delete();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			//调用服务
			NoticeService ns=new NoticeServiceImpl();
			int res = ns.publishNotice(title, filepath, ((Staff)request.getSession().getAttribute("staff")).getStaffno(), new Date(new java.util.Date().getTime()));
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
