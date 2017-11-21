package com.holyshit.Dao;

import java.sql.SQLException;

import com.holyshit.domain.Account;
/**
 * 
 * @author yuan
 *
 */
public interface AccountDao {
	/**
	 * ͨ��Ա����Ų�ѯ
	 * @param id  Ա�����
	 * @return
	 * @throws SQLException
	 */
	Account selectAccountById(String id)throws SQLException;
	/**
	 * ��½�Ժ�ˢ�����ĵ�½ʱ��
	 * @param account  ��½�˻�
	 * @throws SQLException
	 */  
	void updateLltime(Account account)throws SQLException;
}
