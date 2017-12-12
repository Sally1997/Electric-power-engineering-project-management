package com.holyshit.service;

import java.sql.Date;
import java.util.Map;

import com.holyshit.domain.Notice;

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
	
	/**
	 * 查询公告信息
	 * @param noticeno
	 * @return
	 */
	Notice findNoticeById(String noticeno);
}
