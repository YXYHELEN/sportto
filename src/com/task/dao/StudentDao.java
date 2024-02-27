package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.util.C3p0Utils;

public class StudentDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Student> selectStudentList() {
		String sql = "select * from Student  ";
		List<Student> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Student>(Student.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Student findStudentById(String id) {
		try {// 返回查询的信息Student
			return runner.query("select * from Student where id=? ", new BeanHandler<Student>(Student.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteStudent(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Student  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void addStudent(Student Student) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Student(realname,eno,pwd,sex,age) values (?,?,?,?,?)",
					Student.getRealname(),Student.getEno(),Student.getPwd(),Student.getSex(),Student.getAge());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateStudent(Student Student) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Student set realname=?,eno=?,pwd=?,sex=?,age=? where id=?",
					Student.getRealname(),Student.getEno(),Student.getPwd(),Student.getSex(),Student.getAge(), Student.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public List<Student> getStudentPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Student where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and realname like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("uid") != null && !map.get("uid").toString().equals("")) {
			sql += " and id =  " + map.get("uid");
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Student> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Student>(Student.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryStudentCount(Map map) {
		String sql = "select count(*) from Student where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and realname like  '%" + map.get("key").toString() + "%'";
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


	public List<Student> selectStudentByMap(Map map) {
		String sql = "select * from Student where 1 = 1 ";
		List<Student> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Student>(Student.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Student selectStudentByKey(String eno) {
		try {// 返回查询的信息Student
			return runner.query("select * from Student where eno=? ", new BeanHandler<Student>(Student.class),
					eno);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
