package com.holyshit.Dao;

import java.util.List;

public interface AuditDao {
	/**
	 * 查到所有审核了的项目
	 * @param staffno 用户便哈
	 * @return
	 */
	List<Object> selectAuditedPro(String staffno);
}
