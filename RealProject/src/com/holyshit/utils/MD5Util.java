package com.holyshit.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String md5(String src){
		String buffer="";
		byte[] bytes=null;
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			bytes=md.digest(src.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将2进制转化到16进制
		for(byte b:bytes){
			String s=Integer.toHexString(b & 0xff);
			if(s.length()<2)   //如果只有1位,则不补0
				s="0"+s;
			buffer+=s;
		}
		return buffer;
	}
}
