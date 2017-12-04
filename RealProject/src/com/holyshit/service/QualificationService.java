package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.Qualification;

public interface QualificationService {
	List<Qualification> findAllQualifications(String staffno);
}
