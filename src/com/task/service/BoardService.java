package com.task.service;

import java.util.List;
import java.util.Map;

import com.task.entity.Board;

public interface BoardService {

	Board findBoardById(String id);

	void deleteBoard(String id);

	void addBoard(Board Board);

	List<Board> getBoardPage(int pageNum, int pageSize, Map map);

	int queryBoardCount(Map map);

	void updateBoard(Board Board);

}
