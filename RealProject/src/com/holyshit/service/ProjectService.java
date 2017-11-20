package com.holyshit.service;

import java.util.List;

import com.holyshit.domain.Project;

public interface ProjectService {
	/**
	 * 根据用户的id，查找其正在参与的所有项目
	 * @param id 用户id
	 * @return  返回项目列表
	 */
	List<Project> findAllProjectsById(String id);
}
