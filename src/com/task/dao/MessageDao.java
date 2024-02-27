package com.task.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.task.entity.Admin;
import com.task.entity.Message;
import com.task.util.C3p0Utils;

public class MessageDao {
	
	private QueryRunner runner = new QueryRunner(C3p0Utils.getDs());



	public List<Message> selectMessageList() {
		String sql = "select * from Message  ";
		List<Message> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Message>(Message.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public Message findMessageById(String id) {
		try {// 返回查询的信息Message
			return runner.query("select * from Message where id=? ", new BeanHandler<Message>(Message.class),
					Integer.parseInt(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public void deleteMessage(String id) {
		Integer ids = Integer.parseInt(id);
		try {// 执行更改
			runner.update("delete from  Message  where id=?", ids);
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public void addMessage(Message Message) {
		// TODO Auto-generated method stub
		try {
			// 执行插入sql
			runner.update("insert into Message(title,content,times,name) values (?,?,?,?)",
					Message.getTitle(),Message.getContent(),Message.getTimes(),Message.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	public void updateMessage(Message Message) {
		// TODO Auto-generated method stub
		try {// 执行更改
			runner.update("update Message set title=? ,content=? ,times=? ,editor=? where id=?",
					Message.getTitle(),Message.getContent(),Message.getTimes(),Message.getName(), Message.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);// 抛出运行异常
		}
	}



	public List<Message> getMessagePage(int pageNum, int pageSize, Map map) {
		String sql = "select * from Message where 1 = 1 ";
		if (map.get("key") != null && !map.get("key").toString().equals("")) {
			sql += " and title like  '%" + map.get("key").toString() + "%'";
		}
		sql += " limit ?,? ";
		int startNo = (pageNum - 1) * pageSize;
		List<Message> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Message>(Message.class), new Object[] { startNo, pageSize });// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


	public int queryMessageCount(Map map) {
		String sql = "select count(*) from Message where 1 = 1 ";
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


	public List<Message> selectMessageByMap(Map map) {
		String sql = "select * from Message where 1 = 1 ";
		List<Message> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Message>(Message.class));// 添加实体类的适配器进行类的反射
			return list;
		} catch (SQLException e) {// 捕获异常
			throw new RuntimeException(e);// 抛出运行异常
		}
	}


}
