package com.adele.spring.board.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.adele.spring.board.domain.BoardVO;

public interface BoardStore {

	int insertBoard(SqlSession session, BoardVO board);

	List<BoardVO> selectBoardList(SqlSession session, int currentPage);

	BoardVO selectOneByNo(SqlSession session, Integer boardNo);

	int deleteBoard(SqlSession session, Integer boardNo);

	int updateBoard(SqlSession session, BoardVO board);

	List<BoardVO> selectSearchList(SqlSession session, Map<String, String> searchMap, int currentPage);

	int getTotalCount(SqlSession session, Map<String, String> searchMap);

}
