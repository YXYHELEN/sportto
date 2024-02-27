package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.WorkDao;
import com.task.entity.Admin;
import com.task.entity.Work;
import com.task.service.WorkService;

public class WorkServiceImpl implements WorkService{
	
	WorkDao dao = new WorkDao();


	public List<Work> selectWorkList() {
		// TODO Auto-generated method stub
		return  dao.selectWorkList();
	}

	public Work findWorkById(String id) {
		// TODO Auto-generated method stub
		return dao.findWorkById(id);
	}

	public void deleteWork(String id) {
		// TODO Auto-generated method stub
		dao.deleteWork(id);
	}
	
	
	public void addWork(Work Work) {
		// TODO Auto-generated method stub
		dao.addWork(Work);
	}

	public void updateWork(Work Work) {
		// TODO Auto-generated method stub
		dao.updateWork(Work);
	}

	public List<Work> getWorkPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getWorkPage(pageNum,pageSize,map);
	}

	public int queryWorkCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryWorkCount(map);
	}

	public List<Work> selectWorkByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectWorkByMap(map);
	}

	@Override
	public List<Work> selectAll() {
		// TODO Auto-generated method stub
		return  dao.selectAll();
	}


}
