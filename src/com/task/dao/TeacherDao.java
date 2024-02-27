package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Teacher;
import com.task.util.C3p0Utils;

public class TeacherDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Teacher> selectTeacherList() {
		String sql = "select * from Teacher  ";
		List<Teacher> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Teacher findTeacherById(String id) {
		try {// 返回查询的信息Teacher
			return runner.query("select * from Teacher where id=? ", new BeanHandler<Teacher>(Teacher.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteTeacher(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Teacher  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void addTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Teacher(name,tno,pwd,sex,age) values (?,?,?,?,?)",
					Teacher.getName(),Teacher.getTno(),Teacher.getPwd(),Teacher.getSex(),Teacher.getAge());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Teacher set name=?,tno=?,pwd=?,sex=?,age=? where id=?",
					Teacher.getName(),Teacher.getTno(),Teacher.getPwd(),Teacher.getSex(),Teacher.getAge(), Teacher.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public List<Teacher> getTeacherPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Teacher where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and name like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("uid") != null && !map.get("uid").toString().equals("")) {
			sql += " and id =  " + map.get("uid");
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Teacher> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryTeacherCount(Map map) {
		String sql = "select count(*) from Teacher where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and name like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("uid") != null && !map.get("uid").toString().equals("")) {
			sql += " and id =  " + map.get("uid");
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


	public List<Teacher> selectTeacherByMap(Map map) {
		String sql = "select * from Teacher where 1 = 1 ";
		List<Teacher> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Teacher selectTeacherByKey(String data) {
		try {// 返回查询的信息Teacher
			return runner.query("select * from Teacher where tno=? ", new BeanHandler<Teacher>(Teacher.class),
					data);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
