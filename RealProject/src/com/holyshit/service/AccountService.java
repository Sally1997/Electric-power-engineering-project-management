package com.holyshit.service;

import com.holyshit.domain.Account;

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
}
