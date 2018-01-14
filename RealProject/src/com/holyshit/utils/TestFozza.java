package com.holyshit.utils;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.holyshit.Dao.TaskIndexesDao;
import com.holyshit.Dao.impl.TaskIndexesDaoImpl;
import com.holyshit.domain.Document;
import com.holyshit.service.DocumentService;
import com.holyshit.service.impl.DocumentServiceImpl;

public class TestFozza {
	@Test
	public void forTest(){
		DocumentService ds = new DocumentServiceImpl();
		/*Document doc = new Document();
		doc = ds.findDocumentById("a3d5dc54-94f4-40b6-912f-1f1eb3363820");
		
		String filename = doc.getDpath();
		String fname = filename.substring(filename.lastIndexOf(File.separator)+1, filename.lastIndexOf(File.separator)+37);
		
		System.out.println(fname);
		*/
		String taskno = "0000100001";
		TaskIndexesDao tid = new TaskIndexesDaoImpl();
		List<Object> list = new ArrayList<Object>();
		try {
			list = tid.selectIndexPath(taskno);
			for(int haha=0;haha<list.size();haha++){
				String filename = (String) list.get(haha);
				String fname = filename.substring(filename.lastIndexOf(File.separator)+1, filename.lastIndexOf(File.separator)+37);
				System.out.println(fname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
