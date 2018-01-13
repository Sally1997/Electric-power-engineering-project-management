package com.holyshit.utils;

import org.junit.Test;

import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class TestFozza {
	@Test
	public void forTest(){
		DocumentService ds = new DocumentServiceImpl();
		
		String dno = ds.getPDocNo("10001");
		System.out.println(dno);
	}
	
	
}
