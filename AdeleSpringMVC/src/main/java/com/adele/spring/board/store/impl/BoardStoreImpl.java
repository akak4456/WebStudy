package com.adele.spring.board.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.adele.spring.board.domain.BoardVO;
import com.adele.spring.board.store.BoardStore;

@Repository
public class BoardStoreImpl implements BoardStore {
	
	@Override
	public int insertBoard(SqlSession session, BoardVO board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public List<BoardVO> selectBoardList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BoardVO> bList = session.selectList("BoardMapper.selectBoardList", null, rowBounds);
		return bList;
	}

	@Override
	public BoardVO selectOneByNo(SqlSession session, Integer boardNo) {
		BoardVO board = session.selectOne("BoardMapper.selectOneByNo", boardNo);
		return board;
	}

	@Override
	public int deleteBoard(SqlSession session, Integer boardNo) {
		int result = session.delete("BoardMapper.deleteBoard", boardNo);
		return result;
	}

	@Override
	public int updateBoard(SqlSession session, BoardVO board) {
		int result = session.update("BoardMapper.updateBoard", board);
		return result;
	}

	@Override
	public List<BoardVO> selectSearchList(SqlSession session, Map<String, String> searchMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BoardVO> sList = session.selectList("BoardMapper.selectSearchList", searchMap, rowBounds);
		return sList;
	}

	@Override
	public int getTotalCount(SqlSession session, Map<String, String> searchMap) {
		int totalCount = session.selectOne("BoardMapper.getTotalCount", searchMap);
		return totalCount;
	}

}
