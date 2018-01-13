package com.holyshit.service;

import java.util.List;

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
	
	/**
	 * 根据姓名得到姓名和员工编号
	 * @param msg 用户在文本框输入的字符串
	 * @return
	 * @throws Exception 
	 */
	List<Staff> getNameNoByName(String msg) throws Exception;
}
