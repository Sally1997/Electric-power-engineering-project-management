package com.holyshit.service;

public interface PermissionService {
	/***
	 * 是否具有发布公告的权限
	 * @param staffno
	 * @return
	 */
	boolean enablePublicNotice(String staffno);
}
