package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Material;

public interface MaterialService {

	Material findMaterialById(String id);

	void deleteMaterial(String id);

	void addMaterial(Material Material);

	List<Material> getMaterialPage(int pageNum, int pageSize, Map map);

	int queryMaterialCount(Map map);

	void updateMaterial(Material Material);

}
