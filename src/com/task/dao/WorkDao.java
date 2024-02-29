package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Work;
import com.task.util.C3p0Utils;

public class WorkDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Work> selectWorkList() {
		String sql = "select * from Work  ";
		List<Work> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Work>(Work.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Work findWorkById(String id) {
		try {// 返回查询的信息Work
			return runner.query("select * from Work where id=? ", new BeanHandler<Work>(Work.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteWork(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Work  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addWork(Work Work) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Work(title,url,times,tid,time,test,number,cid) values (?,?,?,?,?,?,?,?)",
					Work.getTitle(),Work.getUrl(),Work.getTimes(),Work.getTid(),Work.getTime(),Work.getTest(),Work.getNumber(),Integer.parseInt(Work.getCid()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateWork(Work Work) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Work set url=? ,content=? ,times=? ,tid=? where id=?",
					Work.getTitle(),Work.getUrl(),Work.getTimes(),Work.getTid(), Work.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Work> getWorkPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Work where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("uid") != null && !map.get("uid").toString().equals("")) {
			sql += " and tid =  " + map.get("uid");
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Work> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Work>(Work.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryWorkCount(Map map) {
		String sql = "select count(*) from Work where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("uid") != null && !map.get("uid").toString().equals("")) {
			sql += " and tid =  " + map.get("uid");
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


	public List<Work> selectWorkByMap(Map map) {
		String sql = "select * from Work where 1 = 1 ";
		List<Work> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Work>(Work.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public List<Work> selectAll() {
		String sql = "select * from Work ";
		List<Work> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Work>(Work.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
