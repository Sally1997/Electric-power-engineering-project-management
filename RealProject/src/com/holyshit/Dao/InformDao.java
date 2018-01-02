package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Inform;

public interface InformDao {
	/**
	 * 返回当前新建的立项审核编号，因为时自增数列，直接返回最大值即可
	 * @return
	 * @throws SQLException 
	 */
	List<Object> selectCurPaauditNO() throws SQLException;
	     
	/**
	 * 插入信息表信息
	 * @param info
	 * @throws SQLException 
	 */
	void insertInform(Inform info) throws SQLException;
}
