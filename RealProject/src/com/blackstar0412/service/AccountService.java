package com.blackstar0412.service;

import com.blackstar0412.domain.Account;

public interface AccountService {
	/**
	 * 登陆操作
	 * @param account 登陆账户信息
	 * @return   登陆是否成功
	 */
	boolean login(Account account);
	/**
	 * 根据用户id获得用户logo的存储地址
	 * @param id
	 * @return  用户头像的存储地址
	 */
	String getUserLogoLinkById(String id);
}
