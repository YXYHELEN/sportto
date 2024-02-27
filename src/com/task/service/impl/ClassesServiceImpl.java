package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.ClassesDao;
import com.task.entity.Admin;
import com.task.entity.Classes;
import com.task.service.ClassesService;

public class ClassesServiceImpl implements ClassesService{
	
	ClassesDao dao = new ClassesDao();


	public List<Classes> selectClassesList() {
		// TODO Auto-generated method stub
		return  dao.selectClassesList();
	}

	public Classes findClassesById(String id) {
		// TODO Auto-generated method stub
		return dao.findClassesById(id);
	}

	public void deleteClasses(String id) {
		// TODO Auto-generated method stub
		dao.deleteClasses(id);
	}
	
	
	public void addClasses(Classes Classes) {
		// TODO Auto-generated method stub
		dao.addClasses(Classes);
	}

	public void updateClasses(Classes Classes) {
		// TODO Auto-generated method stub
		dao.updateClasses(Classes);
	}

	public List<Classes> getClassesPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getClassesPage(pageNum,pageSize,map);
	}

	public int queryClassesCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryClassesCount(map);
	}

	public List<Classes> selectClassesByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectClassesByMap(map);
	}


}
