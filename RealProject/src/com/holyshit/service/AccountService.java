package com.holyshit.service;

import com.holyshit.domain.Account;

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
}
