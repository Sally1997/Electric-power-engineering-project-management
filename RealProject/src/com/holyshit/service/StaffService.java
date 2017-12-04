package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public interface StaffService {
	List<StaffDuty> findAllStaffs(String pno);
	void delAllStaffs(String[] staffnos,String pno);
	Staff findAStaff(String staffno);
}
