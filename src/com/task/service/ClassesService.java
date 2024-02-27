package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Classes;

public interface ClassesService {

	Classes findClassesById(String id);

	void deleteClasses(String id);

	void addClasses(Classes Classes);

	List<Classes> getClassesPage(int pageNum, int pageSize, Map map);

	int queryClassesCount(Map map);

	void updateClasses(Classes Classes);

}
