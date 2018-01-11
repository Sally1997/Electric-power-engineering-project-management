package com.holyshit.utils;

import java.sql.SQLException;

import org.junit.Test;

import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class TestFozza {
	@Test
	public void forTest(){
		int x = 20;
		x /= 10;
		if(x%10>0){
			x += 1;
		}
		System.out.println(x);
	}
	
	
}
