package com.holyshit.service;

public interface PermissionService {
	/***
	 * 是否具有发布公告的权限
	 * @param staffno
	 * @return
	 */
	boolean enablePublicNotice(String staffno);
	
	
	/**
	 * 是否具有添加和删除员工的权限
	 * @param id
	 * @return
	 */
	boolean enableDeleteAndAddStaff(String staffno,String pno);
}
