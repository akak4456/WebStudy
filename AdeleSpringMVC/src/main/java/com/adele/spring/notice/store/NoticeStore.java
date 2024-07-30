package com.adele.spring.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.adele.spring.notice.domain.NoticeVO;

public interface NoticeStore {
	/**
	 * 공지사항 등록 Store
	 * @param session
	 * @param notice
	 * @return Integer
	 */
	int insertNotice(SqlSession session, NoticeVO notice);

	List<NoticeVO> selectNoticeList(SqlSession session, int currentPage);
	
	int getTotalCount(SqlSession session);

	NoticeVO selectOneByNo(SqlSession session, int noticeNo);

	int deleteNotice(SqlSession session, Integer noticeNo);

	int updateNotice(SqlSession session, NoticeVO notice);

	List<NoticeVO> selectSearchList(SqlSession session, Map<String, String> paramMap);
}
