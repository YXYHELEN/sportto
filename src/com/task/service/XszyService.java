package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Statics;
import com.task.entity.Xszy;

public interface XszyService {

	Xszy findXszyById(String id);

	void deleteXszy(String id);

	void addXszy(Xszy Xszy);

	List<Xszy> getXszyPage(int pageNum, int pageSize, Map map);

	int queryXszyCount(Map map);

	void updateXszy(Xszy Xszy);

	List<Statics> selectStaticsXszy();

}
