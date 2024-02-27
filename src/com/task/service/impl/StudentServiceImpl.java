package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.StudentDao;
import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	StudentDao dao = new StudentDao();


	public List<Student> selectStudentList() {
		// TODO Auto-generated method stub
		return  dao.selectStudentList();
	}

	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		return dao.findStudentById(id);
	}

	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		dao.deleteStudent(id);
	}
	
	
	public void addStudent(Student Student) {
		// TODO Auto-generated method stub
		dao.addStudent(Student);
	}

	public void updateStudent(Student Student) {
		// TODO Auto-generated method stub
		dao.updateStudent(Student);
	}

	public List<Student> getStudentPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getStudentPage(pageNum,pageSize,map);
	}

	public int queryStudentCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryStudentCount(map);
	}

	public List<Student> selectStudentByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectStudentByMap(map);
	}

	@Override
	public Student selectStudentByKey(String eno) {
		// TODO Auto-generated method stub
		return dao.selectStudentByKey(eno);
	}


}
