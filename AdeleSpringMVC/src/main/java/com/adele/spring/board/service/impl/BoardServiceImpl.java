package com.adele.spring.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adele.spring.board.domain.BoardVO;
import com.adele.spring.board.service.BoardService;
import com.adele.spring.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSession session;
	@Autowired
	private BoardStore bStore;
	
	
	@Override
	public int insertBoard(BoardVO board) {
		int result = bStore.insertBoard(session,board);
		return result;
	}


	@Override
	public List<BoardVO> selectBoardList(int currentPage) {
		List<BoardVO> bList = bStore.selectBoardList(session, currentPage);
		return bList;
	}


	@Override
	public BoardVO selectOneByNo(Integer boardNo) {
		BoardVO board = bStore.selectOneByNo(session, boardNo);
		return board;
	}


	@Override
	public int deleteBoard(Integer boardNo) {
		int result = bStore.deleteBoard(session, boardNo);
		return result;
	}


	@Override
	public int updateBoard(BoardVO board) {
		int result = bStore.updateBoard(session, board);
		return result;
	}


	@Override
	public List<BoardVO> selectSearchList(Map<String, String> searchMap, int currentPage) {
		List<BoardVO> sList = bStore.selectSearchList(session, searchMap, currentPage);
		return sList;
	}


	@Override
	public int getTotalCount(Map<String, String> searchMap) {
		int totalCount = bStore.getTotalCount(session, searchMap);
		return totalCount;
	}

}
