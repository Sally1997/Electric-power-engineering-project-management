package com.holyshit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.holyshit.domain.Document;
import com.holyshit.domain.Staff;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class UploadDocument extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		DiskFileItemFactory dff=new DiskFileItemFactory();
		//设置临时文件目录
		dff.setRepository(new File(getServletContext().getRealPath("/tmp")));
		ServletFileUpload upload=new ServletFileUpload(dff);
		upload.setFileSizeMax(10*1024*1024); //设置文件的大小为10M
		if(upload.isMultipartContent(request)){
			List<FileItem> pars=null;
			String dtitle=null;
			DocumentService ds=new DocumentServiceImpl();
			try {
				try {
					pars = upload.parseRequest(request);
				} catch (FileUploadBase.FileSizeLimitExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(FileItem f:pars){
				if(f.isFormField()){
					dtitle=f.getString();
					dtitle=new String(dtitle.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println("取到的值为:"+dtitle);
				}else{
					//上传文件
					if(dtitle!=null){
						String dno=UUID.randomUUID().toString();
						String filename=f.getName();
						System.out.println("文件名:"+filename);
						//获取后缀名
						String ftype=filename.substring(filename.lastIndexOf(".")+1);
						String uloadpno=((Staff)request.getSession().getAttribute("staff")).getStaffno();
						String realpath=dno+"_"+dtitle+"."+ftype;
						

						//写入文件
						String hash=Integer.toHexString(dtitle.hashCode());
						
						String base="d:/var/ProjectData/ProjectFile/"+hash.charAt(0)+"/"+hash.charAt(1);
						File filepath=new File(base);
						//如果不存在，则创建目录
						if(!filepath.exists())
							filepath.mkdirs();
						File last=new File(filepath.getPath()+"/"+realpath);
						try {
							f.write(last);
							f.delete();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return;
						}
							
						boolean res = ds.uploadDocument(dno, dtitle, last.getPath(), uloadpno, "00000", ftype, "0",(int)f.getSize());
						response.setCharacterEncoding("UTF-8");
						if(res){
							response.getWriter().write("ok");
						}else{
							response.getWriter().write("error");
						}
					}
					else{
						System.out.println("error");
					}
					
				}
			}
			
		}
	}

}
