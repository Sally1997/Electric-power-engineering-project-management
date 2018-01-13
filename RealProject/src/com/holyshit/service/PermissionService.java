package com.holyshit.service;

public interface PermissionService {
	/**
	 * 查看是否具有改变负责人的权限
	 * @param staffno
	 * @param pno
	 * @return
	 */
	boolean enableChangeCharge(String staffno,String id);
	
	/**
	 * 是否具有新建阶段的权限
	 * @param pno
	 * @param staffno
	 * @return
	 */
	boolean enableNewStage(String pno,String staffno);
	
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
	
	/**
	 * 是否具有审批普通文档的权限
	 * @param staffno
	 * @return
	 */
	boolean enableCheckDocument(String staffno);
	
	/**
	 * 能否进入人员管理界面
	 * @param pno
	 * @return
	 */
	boolean enableEnterHr(String pno);
}
