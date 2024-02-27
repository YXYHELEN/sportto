package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Message;

public interface MessageService {

	Message findMessageById(String id);

	void deleteMessage(String id);

	void addMessage(Message Message);

	List<Message> getMessagePage(int pageNum, int pageSize, Map map);

	int queryMessageCount(Map map);

	void updateMessage(Message Message);

}
