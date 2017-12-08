package com.holyshit.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.holyshit.domain.ProjectInfo;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

import net.sf.json.JSONArray;

public class TestFozza {
	@Test
	public void forTest() throws SQLException{
		int current_page = 1;
		int page_size = 5;
		
		ProjectService ps = new ProjectServiceImpl();
		Map<String,Object> info_map = new HashMap<String, Object>();
		info_map = ps.getProjectManageInfo(current_page, page_size);
		
		List<ProjectInfo> plist = (List<ProjectInfo>) info_map.get("pi_list");
		for(int i=0;i<plist.size();i++){
			System.out.println(plist.get(i));
		}
		
		String s = JSONArray.fromObject(info_map).toString();
		System.out.println(s);
	}
}
