package com.task.service.impl;

import java.util.List;
import java.util.Map;

import com.task.dao.BoardDao;
import com.task.entity.Admin;
import com.task.entity.Board;
import com.task.service.BoardService;

public class BoardServiceImpl implements BoardService{
	
	BoardDao dao = new BoardDao();


	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return  dao.selectBoardList();
	}

	public Board findBoardById(String id) {
		// TODO Auto-generated method stub
		return dao.findBoardById(id);
	}

	public void deleteBoard(String id) {
		// TODO Auto-generated method stub
		dao.deleteBoard(id);
	}
	
	
	public void addBoard(Board Board) {
		// TODO Auto-generated method stub
		dao.addBoard(Board);
	}

	public void updateBoard(Board Board) {
		// TODO Auto-generated method stub
		dao.updateBoard(Board);
	}

	public List<Board> getBoardPage(int pageNum, int pageSize, Map map) {
		// TODO Auto-generated method stub
		return dao.getBoardPage(pageNum,pageSize,map);
	}

	public int queryBoardCount(Map map) {
		// TODO Auto-generated method stub
		return  dao.queryBoardCount(map);
	}

	public List<Board> selectBoardByMap(Map map) {
		// TODO Auto-generated method stub
		return dao.selectBoardByMap(map);
	}


}
