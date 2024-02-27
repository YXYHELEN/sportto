package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.TeacherDao;
import com.task.entity.Admin;
import com.task.entity.Teacher;
import com.task.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	
	TeacherDao dao = new TeacherDao();


	public List<Teacher> selectTeacherList() {
		// TODO Auto-generated method stub
		return  dao.selectTeacherList();
	}

	public Teacher findTeacherById(String id) {
		// TODO Auto-generated method stub
		return dao.findTeacherById(id);
	}

	public void deleteTeacher(String id) {
		// TODO Auto-generated method stub
		dao.deleteTeacher(id);
	}
	
	
	public void addTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		dao.addTeacher(Teacher);
	}

	public void updateTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		dao.updateTeacher(Teacher);
	}

	public List<Teacher> getTeacherPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getTeacherPage(pageNum,pageSize,map);
	}

	public int queryTeacherCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryTeacherCount(map);
	}

	public List<Teacher> selectTeacherByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectTeacherByMap(map);
	}

	@Override
	public Teacher selectTeacherByKey(String eno) {
		// TODO Auto-generated method stub
		return dao.selectTeacherByKey(eno);
	}


}
