package com.holyshit.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.holyshit.domain.PDocAudit;
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
	
	/**
	 * 插入立项文档审核信息
	 * @param paa 立项审核信息对象
	 * @throws SQLException
	 */
	void insertpdocaudit(PDocAudit pda) throws SQLException;
	
	/**
	 * 审核界面项目相关信息
	 * @param mno 消息表主键
	 * @return
	 * @throws SQLException 
	 */
	Map<String,Object> selectProAuditInfo(String mno) throws SQLException;
	
	/**
	 * 项目审核意见相关
	 * @param mno
	 * @return
	 * @throws SQLException 
	 */
	List<Map<String,Object>> selectProAuditAdvInfo(String mno) throws SQLException;
}
