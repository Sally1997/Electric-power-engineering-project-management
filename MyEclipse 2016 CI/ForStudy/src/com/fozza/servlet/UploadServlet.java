package com.fozza.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		boolean ismpc = ServletFileUpload.isMultipartContent(request);
		if(!ismpc){
			throw new RuntimeException("heh");
		}
		
		//��������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//����һ��ServletFileUpload��������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//����request����,�õ�һ������
		try {
			List<FileItem> flist = sfu.parseRequest(request);
			
			for(FileItem fileitem : flist){
				if(fileitem.isFormField()){
					//��ͨ����
					processFormFiled(fileitem);
				}
				else{
					//�ļ���
					processUploadFiled(fileitem);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void processUploadFiled(FileItem fileitem) {
		//获取上传文件
		
		
		//得到文件输入流
		try {
			InputStream is = fileitem.getInputStream();
			
			//名字
			String filename = fileitem.getName();
			if(filename!=null){
				filename=FilenameUtils.getName(filename);
			}
			
			//解决同名
			filename = UUID.randomUUID() + "_" + filename;
			
			//创建一个文件存盘目录
			String directorypath = "D:/RealProject/Upload";
			//String directorypath = this.getServletContext().getRealPath("/Upload");
			File store_directory = new File(directorypath);//相当于路径下的文件夹
			if(!store_directory.exists()){
				store_directory.mkdirs();//创建一个制定的目录
			}
			//将目录打散
			String child_directory_path = makeDirectoryPath(store_directory,filename);
			
			
			File file = new File(store_directory,child_directory_path+File.separator+filename);
			
			FileOutputStream fos = new FileOutputStream(file);
			
			//将文件写入到文件夹里面
			int len=0;
			byte[] b = new byte[1024];
			while((len=is.read(b))!=-1){
				fos.write(b,0,len);
			}
			
			fos.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String makeDirectoryPath(File store_directory,String filename) {
		int hascode = filename.hashCode();//返回32位哈希编码
		String code = Integer.toHexString(hascode);//将哈希码转换为16进制字符
		String child_directory_path = code.charAt(0)+ File.separator + code.charAt(1);
		File file = new File(store_directory,child_directory_path);
		
		if(!file.exists()){
			file.mkdirs();
		}
		return child_directory_path;
	}

	public void processFormFiled(FileItem fileitem) {
		// TODO Auto-generated method stub
		String filedname = fileitem.getFieldName();
		String filedvalue = fileitem.getString();
		System.out.println(filedname+"="+filedvalue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
