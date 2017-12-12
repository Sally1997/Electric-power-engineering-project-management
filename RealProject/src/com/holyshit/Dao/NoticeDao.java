package com.holyshit.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Notice;

public interface NoticeDao {
	/**
	 * 插入一条新公告到公告表
	 * @param title
	 * @param path
	 * @param pubpno
	 * @param time
	 * @return
	 * @throws SQLException
	 */
	int addNotice(String noticeno,String title,String path,String pubpno,Date time)throws SQLException;
	
	/**
	 * 分页查询所有的公告
	 * @return
	 * @throws SQLException
	 */
	List<Notice> selectAllNoticeByPage(int cur,int pagesize)throws SQLException;
	
	/**
	 * 公告的总数量
	 * @return
	 * @throws SQLException
	 */
	long totalNumNotice() throws SQLException;
	
	/**
	 * 根据公告id查询公告信息
	 * @param noticeno
	 * @return
	 * @throws SQLException
	 */
	Notice selectNoticeById(String noticeno)throws SQLException;
}
