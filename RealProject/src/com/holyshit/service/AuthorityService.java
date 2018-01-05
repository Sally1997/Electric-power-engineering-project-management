package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.Authority;

public interface AuthorityService {
	/**
	 * 查看所有的权限列表
	 * @return
	 */
	List<Authority> findAllAuthority();
	
	/**
	 * 根据id查询当前用户的权限列表
	 * @param staffno
	 * @return
	 */
	List<Authority> findAuthorityById(String staffno);
	
	/**
	 * 设置员工权限
	 * @param staffno
	 * @param para
	 * @return
	 */
	boolean setAuthority(String staffno,String para);
}
