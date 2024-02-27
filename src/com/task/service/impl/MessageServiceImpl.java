package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.MessageDao;
import com.task.entity.Admin;
import com.task.entity.Message;
import com.task.service.MessageService;

public class MessageServiceImpl implements MessageService{
	
	MessageDao dao = new MessageDao();


	public List<Message> selectMessageList() {
		// TODO Auto-generated method stub
		return  dao.selectMessageList();
	}

	public Message findMessageById(String id) {
		// TODO Auto-generated method stub
		return dao.findMessageById(id);
	}

	public void deleteMessage(String id) {
		// TODO Auto-generated method stub
		dao.deleteMessage(id);
	}
	
	
	public void addMessage(Message Message) {
		// TODO Auto-generated method stub
		dao.addMessage(Message);
	}

	public void updateMessage(Message Message) {
		// TODO Auto-generated method stub
		dao.updateMessage(Message);
	}

	public List<Message> getMessagePage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getMessagePage(pageNum,pageSize,map);
	}

	public int queryMessageCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryMessageCount(map);
	}

	public List<Message> selectMessageByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectMessageByMap(map);
	}


}
