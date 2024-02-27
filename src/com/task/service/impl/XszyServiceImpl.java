package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.XszyDao;
import com.task.entity.Admin;
import com.task.entity.Statics;
import com.task.entity.Xszy;
import com.task.service.XszyService;

public class XszyServiceImpl implements XszyService{
	
	XszyDao dao = new XszyDao();


	public List<Xszy> selectXszyList() {
		// TODO Auto-generated method stub
		return  dao.selectXszyList();
	}

	public Xszy findXszyById(String id) {
		// TODO Auto-generated method stub
		return dao.findXszyById(id);
	}

	public void deleteXszy(String id) {
		// TODO Auto-generated method stub
		dao.deleteXszy(id);
	}
	
	
	public void addXszy(Xszy Xszy) {
		// TODO Auto-generated method stub
		dao.addXszy(Xszy);
	}

	public void updateXszy(Xszy Xszy) {
		// TODO Auto-generated method stub
		dao.updateXszy(Xszy);
	}

	public List<Xszy> getXszyPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getXszyPage(pageNum,pageSize,map);
	}

	public int queryXszyCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryXszyCount(map);
	}

	public List<Xszy> selectXszyByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectXszyByMap(map);
	}

	@Override
	public List<Statics> selectStaticsXszy() {
		// TODO Auto-generated method stub
		return dao.selectStaticsXszy();
	}


}
