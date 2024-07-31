package com.adele.spring.board.service;

import java.util.List;
import java.util.Map;

import com.adele.spring.board.domain.BoardVO;

public interface BoardService {

	int insertBoard(BoardVO board);
	
	List<BoardVO> selectBoardList(int currentPage);

	BoardVO selectOneByNo(Integer boardNo);

	int deleteBoard(Integer boardNo);

	int updateBoard(BoardVO board);

	/**
	 * 게시글 검색 조회 Service
	 * @param searchMap
	 * @return
	 */
	List<BoardVO> selectSearchList(Map<String, String> searchMap, int currentPage);

	int getTotalCount(Map<String, String> searchMap);
	
	

}
