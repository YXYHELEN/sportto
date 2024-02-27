package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Board;
import com.task.util.C3p0Utils;

public class BoardDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Board> selectBoardList() {
		String sql = "select * from Board  ";
		List<Board> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Board>(Board.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Board findBoardById(String id) {
		try {// 返回查询的信息Board
			return runner.query("select * from Board where id=? ", new BeanHandler<Board>(Board.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteBoard(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Board  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addBoard(Board Board) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Board(title,content,times,editor) values (?,?,?,?)",
					Board.getTitle(),Board.getContent(),Board.getTimes(),Board.getEditor());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateBoard(Board Board) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Board set title=? ,content=? ,editor=? where id=?",
					Board.getTitle(),Board.getContent(),Board.getEditor(), Board.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Board> getBoardPage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Board where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Board> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Board>(Board.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryBoardCount(Map map) {
		String sql = "select count(*) from Board where 1 = 1 ";
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


	public List<Board> selectBoardByMap(Map map) {
		String sql = "select * from Board where 1 = 1 ";
		List<Board> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Board>(Board.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
