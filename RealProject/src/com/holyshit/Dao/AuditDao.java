package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;

import com.holyshit.domain.Projaprlaudit;

public interface AuditDao {
	/**
	 * 查到所有审核了的项目
	 * @param staffno 用户便哈
	 * @return
	 */
	List<Object> selectAuditedPro(String staffno);
	
	/**
	 * 插入理想审核信息
	 * @param paa 立项审核信息对象
	 * @throws SQLException
	 */
	void insertprojaprlaudit(Projaprlaudit paa) throws SQLException;
}
