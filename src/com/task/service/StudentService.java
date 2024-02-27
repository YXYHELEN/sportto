package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Student;

public interface StudentService {

	Student findStudentById(String id);

	void deleteStudent(String id);

	void addStudent(Student Student);

	List<Student> getStudentPage(int pageNum, int pageSize, Map map);

	int queryStudentCount(Map map);

	void updateStudent(Student Student);

	Student selectStudentByKey(String eno);

}
