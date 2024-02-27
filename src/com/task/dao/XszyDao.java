package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Statics;
import com.task.entity.Xszy;
import com.task.util.C3p0Utils;

public class XszyDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Xszy> selectXszyList() {
		String sql = "select * from Xszy  ";
		List<Xszy> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Xszy>(Xszy.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Xszy findXszyById(String id) {
		try {// 返回查询的信息Xszy
			return runner.query("select * from Xszy where id=? ", new BeanHandler<Xszy>(Xszy.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteXszy(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Xszy  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addXszy(Xszy Xszy) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Xszy(wid,url,sid,times) values (?,?,?,?)",
					Xszy.getWid(),Xszy.getUrl(),Xszy.getSid(),Xszy.getTimes());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateXszy(Xszy Xszy) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Xszy set state=? ,pytimes=? ,points=? ,note=?,type=? where id=?",
					Xszy.getState(),Xszy.getPytimes(),Xszy.getPoints(),Xszy.getNote(),Xszy.getType(), Xszy.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Xszy> getXszyPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Xszy where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and times like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("sid") != null && !map.get("sid").toString().equals("")) {
			sql += " and sid =  " + map.get("sid");
		}
		if (map.get("tid") != null && !map.get("tid").toString().equals("")) {
			sql += " and wid in (select id from work where tid =  "+ map.get("tid")+")";
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Xszy> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Xszy>(Xszy.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryXszyCount(Map map) {
		String sql = "select count(*) from Xszy where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and times like  '%" + map.get("key").toString() + "%'";
		}
		if (map.get("sid") != null && !map.get("sid").toString().equals("")) {
			sql += " and sid =  " + map.get("sid");
		}
		if (map.get("tid") != null && !map.get("tid").toString().equals("")) {
			sql += " and wid in (select id from work where tid =  "+ map.get("tid")+")";
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


	public List<Xszy> selectXszyByMap(Map map) {
		String sql = "select * from Xszy where 1 = 1 ";
		List<Xszy> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Xszy>(Xszy.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public List<Statics> selectStaticsXszy() {
		String sql = "select count(1) as counts ,type as names from xszy GROUP BY names  ";
		List<Statics> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Statics>(Statics.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
