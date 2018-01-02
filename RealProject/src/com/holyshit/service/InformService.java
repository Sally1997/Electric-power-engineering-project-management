package com.holyshit.service;

import com.holyshit.domain.Inform;

public interface InformService {
	/**
	 * 获得最新生成的项目审核主键编号
	 * @return
	 */
	String getNewPaauditNo();
	
	/**
	 * 添加信息表信息
	 * @param info
	 */
	void addInform(Inform info);
}
