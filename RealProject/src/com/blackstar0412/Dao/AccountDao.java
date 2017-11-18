package com.blackstar0412.Dao;

import java.sql.SQLException;

import com.blackstar0412.domain.Account;

public interface AccountDao {
	/**
	 * 通过员工编号查询
	 * @param id  员工编号
	 * @return
	 * @throws SQLException
	 */
	Account selectAccountById(String id)throws SQLException;
	/**
	 * 登陆以后刷新最后的登陆时间
	 * @param account  登陆账户
	 * @throws SQLException
	 */
	void updateLltime(Account account)throws SQLException;
}
