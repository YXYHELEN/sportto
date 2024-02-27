package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Teacher;

public interface TeacherService {

	Teacher findTeacherById(String id);

	void deleteTeacher(String id);

	void addTeacher(Teacher Teacher);

	List<Teacher> getTeacherPage(int pageNum, int pageSize, Map map);

	int queryTeacherCount(Map map);

	void updateTeacher(Teacher Teacher);

	Teacher selectTeacherByKey(String eno);

}
