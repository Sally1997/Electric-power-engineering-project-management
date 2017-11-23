package com.holyshit.service;

import com.holyshit.domain.Account;
<<<<<<< HEAD

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
=======
import com.holyshit.domain.Staff;

public interface AccountService {
	/**
	 * 鐢ㄦ埛鐧婚檰
	 * @param account
	 * @return
	 */
	boolean login(Account account);
	
	
	/**
	 * 鑾峰彇鐢ㄦ埛淇℃伅
	 * @param id
	 * @return
	 */
	Staff getUserById(String id);
>>>>>>> branch 'devolope' of git@github.com:Sally1997/Electric-power-engineering-project-management.git
}
