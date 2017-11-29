package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.Account;

public interface AccountDao {
	/**
	 * 通锟斤拷员锟斤拷锟斤拷挪锟窖�
	 * @param id  员锟斤拷锟斤拷锟�
	 * @return
	 * @throws SQLException
	 */
	Account selectAccountById(String id)throws SQLException;
	/**
	 * 锟斤拷陆锟皆猴拷刷锟斤拷锟斤拷锟侥碉拷陆时锟斤拷
	 * @param account  锟斤拷陆锟剿伙拷
	 * @throws SQLException
	 */  
	void updateLltime(Account account)throws SQLException;       
}
