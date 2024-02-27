package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Work;

public interface WorkService {

	Work findWorkById(String id);

	void deleteWork(String id);

	void addWork(Work Work);

	List<Work> getWorkPage(int pageNum, int pageSize, Map map);

	int queryWorkCount(Map map);

	void updateWork(Work Work);

	List<Work> selectAll();

}
