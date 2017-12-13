package com.holyshit.domain;

import java.util.List;


public class PageBean {
	private int currentPage;
	private int pageSize;
	private int count;
	private int totalPage;
	private List<StaffDuty> staffs;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int CurrentPage) {
		currentPage = CurrentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int PageSize) {
		pageSize = PageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<StaffDuty> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<StaffDuty> staffs) {
		this.staffs = staffs;
	}
}
