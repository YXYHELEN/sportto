package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.MaterialDao;
import com.task.entity.Admin;
import com.task.entity.Material;
import com.task.service.MaterialService;

public class MaterialServiceImpl implements MaterialService{
	
	MaterialDao dao = new MaterialDao();


	public List<Material> selectMaterialList() {
		// TODO Auto-generated method stub
		return  dao.selectMaterialList();
	}

	public Material findMaterialById(String id) {
		// TODO Auto-generated method stub
		return dao.findMaterialById(id);
	}

	public void deleteMaterial(String id) {
		// TODO Auto-generated method stub
		dao.deleteMaterial(id);
	}
	
	
	public void addMaterial(Material Material) {
		// TODO Auto-generated method stub
		dao.addMaterial(Material);
	}

	public void updateMaterial(Material Material) {
		// TODO Auto-generated method stub
		dao.updateMaterial(Material);
	}

	public List<Material> getMaterialPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getMaterialPage(pageNum,pageSize,map);
	}

	public int queryMaterialCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryMaterialCount(map);
	}

	public List<Material> selectMaterialByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectMaterialByMap(map);
	}


}
