package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Classes;
import com.task.util.C3p0Utils;

public class ClassesDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Classes> selectClassesList() {
		String sql = "select * from Classes  ";
		List<Classes> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Classes>(Classes.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Classes findClassesById(String id) {
		try {// 返回查询的信息Classes
			return runner.query("select * from Classes where id=? ", new BeanHandler<Classes>(Classes.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteClasses(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Classes  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addClasses(Classes Classes) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Classes(name) values (?)",
					Classes.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateClasses(Classes Classes) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Classes set name=? where id=?",
					Classes.getName(), Classes.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Classes> getClassesPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Classes where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and name like  '%" + map.get("key").toString() + "%'";
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Classes> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Classes>(Classes.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryClassesCount(Map map) {
		String sql = "select count(*) from Classes where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and name like  '%" + map.get("key").toString() + "%'";
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


	public List<Classes> selectClassesByMap(Map map) {
		String sql = "select * from Classes where 1 = 1 ";
		List<Classes> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Classes>(Classes.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
