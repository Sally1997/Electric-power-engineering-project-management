package com.holyshit.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.holyshit.Dao.NoticeDao;
import com.holyshit.Dao.impl.NoticeDaoImpl;
import com.holyshit.domain.Notice;
import com.holyshit.service.NoticeService;
import com.holyshit.utils.ConnectionManager;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public int publishNotice(String title, String path, String pubpno, Date time) {
		// TODO Auto-generated method stub
		NoticeDao nd=new NoticeDaoImpl();
		try {
			return nd.addNotice(title, path, pubpno, time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection();
		}
		return 0;
	}

	@Override
	public Map<String, Object> showAllNoticeByPage(int cur, int pagesize) {
		// TODO Auto-generated method stub
		
//		resMap.put("budgets", projectbudget.toString());
//		resMap.put("currentPage", cur);
//		resMap.put("pageSize", pagesize);
//		resMap.put("pageNum", totalSize%pagesize==0?totalSize/pagesize:totalSize/pagesize+1);
//		resMap.put("projectNum", projects.size());
		
		NoticeDao nd=new NoticeDaoImpl();
		List<Notice> notices=null;
		long totalNum=0;
		try {
			notices=nd.selectAllNoticeByPage(cur, pagesize);
			totalNum=nd.totalNumNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> res=new HashMap<String, Object>();
		res.put("noticelist", notices);
		res.put("currentPage", cur);
		res.put("pageSize", pagesize);
		res.put("pageNum", totalNum%pagesize==0?totalNum/pagesize:totalNum/pagesize+1);
		res.put("totalNum", totalNum);
		return res;
	}

	@Override
	public Notice findNoticeById(String noticeno) {
		// TODO Auto-generated method stub
		NoticeDao nd=new NoticeDaoImpl();
		try {
			return nd.selectNoticeById(noticeno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
