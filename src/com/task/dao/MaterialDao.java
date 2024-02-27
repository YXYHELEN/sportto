package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Material;
import com.task.util.C3p0Utils;

public class MaterialDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Material> selectMaterialList() {
		String sql = "select * from Material  ";
		List<Material> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Material>(Material.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Material findMaterialById(String id) {
		try {// 返回查询的信息Material
			return runner.query("select * from Material where id=? ", new BeanHandler<Material>(Material.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteMaterial(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Material  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addMaterial(Material Material) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Material(title,content,times,url) values (?,?,?,?)",
					Material.getTitle(),Material.getContent(),Material.getTimes(),Material.getUrl());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateMaterial(Material Material) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Material set title=? ,content=? ,url=? where id=?",
					Material.getTitle(),Material.getContent(),Material.getUrl(), Material.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Material> getMaterialPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Material where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Material> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Material>(Material.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryMaterialCount(Map map) {
		String sql = "select count(*) from Material where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		try {
			Long count = (Long) runner.query(sql, new ScalarHandler());
			// 将long的类型转成int类型
			return count.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public List<Material> selectMaterialByMap(Map map) {
		String sql = "select * from Material where 1 = 1 ";
		List<Material> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Material>(Material.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
