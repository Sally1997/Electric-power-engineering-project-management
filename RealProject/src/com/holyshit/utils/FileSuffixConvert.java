package com.holyshit.utils;
/**
 * 进行后缀名的转化
 * @author Administrator
 *
 */
public class FileSuffixConvert {
	public static String[] convert(String type){
		if(type.equals("docx")){
			String[] types={"docx","doc","docm","dotm","dotx"};
			return types;
		}else if(type.equals("ppt")){
			String[] types={"pptx","ppsx","ppt","pps","pptm","potm","ppam","potx","posm"};
			return types;
		}else if(type.equals("pdf")){
			String[] types={"pdf"};
			return types;
		}else if(type.equals("xls")){
			String[] types={"xlsx","xlsb","xls","xlsm"};
			return types;
		}else if(type.equals("video")){
			String[] types={"mp4","avi","3gp","wmv","rmvb","mov","flv"};
			return types;
		}else{
			
		}
		return null;
	}
}
