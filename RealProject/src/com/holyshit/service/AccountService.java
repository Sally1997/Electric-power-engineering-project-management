package com.holyshit.service;

import com.holyshit.domain.Account;
<<<<<<< HEAD

public interface AccountService {
	/**
	 * ��½����
	 * @param account ��½�˻���Ϣ
	 * @return   ��½�Ƿ�ɹ�
	 */
	boolean login(Account account);
	/**
	 * �����û�id����û�logo�Ĵ洢��ַ
	 * @param id
	 * @return  �û�ͷ��Ĵ洢��ַ
	 */
	String getUserLogoLinkById(String id);
=======
import com.holyshit.domain.Staff;

public interface AccountService {
	/**
	 * 用户登陆
	 * @param account
	 * @return
	 */
	boolean login(Account account);
	
	
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	Staff getUserById(String id);
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
}
