package com.holyshit.service;

import java.sql.Date;
import java.util.Map;

public interface NoticeService {
	/**
	 * 发布一条公告
	 * @param title
	 * @param path
	 * @param pubpno
	 * @param time
	 * @return
	 */
	int publishNotice(String title,String path,String pubpno,Date time);
	
	/**
	 * 分页显示公告
	 * @param cur
	 * @param pagesize
	 * @return
	 */
	Map<String, Object> showAllNoticeByPage(int cur,int pagesize);
}
