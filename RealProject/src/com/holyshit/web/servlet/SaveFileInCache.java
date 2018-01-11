package com.holyshit.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Document;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class SaveFileInCache extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
		//获取文档id
			String dno=request.getParameter("dno");
			if(dno==null){
				response.getWriter().write("dnError");
				return;
			}
			DocumentService ds=new DocumentServiceImpl();
			Document doc = ds.findDocumentById(dno);
			if(doc==null){
				response.getWriter().write("findDocumentError");
				return;
			}
			String filepath=doc.getDpath();
			String filename=doc.getDtitle()+filepath.substring(filepath.lastIndexOf("."));
			InputStream input=new FileInputStream(filepath);
			
			//新建临时文件，用于预览
			File f=new File(getServletContext().getRealPath("/tmp"));
			if(!f.exists())
				f.mkdirs();  //新建目录
			String newfile=dno+filename.substring(filename.lastIndexOf("."));
			String lastname=filename.substring(filename.lastIndexOf(".")+1);
			File exist=new File(f.getPath()+File.separator+newfile);
			
			//压入session
			request.getSession().setAttribute("previewFile", newfile);
			
			
			if((!exist.exists())){
				//文件类型选择
			
				//新建文件
				OutputStream outFile=new FileOutputStream(f.getPath()+File.separator+newfile);
				int len=0;
			
				//缓冲区
				byte b[]=new byte[1024];
				while((len=input.read(b))!=-1){
					outFile.write(b, 0, len);
				}
				//关闭流
				outFile.close();
			}
			input.close();
			response.getWriter().write("ok");
	}

}
