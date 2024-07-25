package com.adele.spring.notice.store;

import java.util.List;

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

	List<NoticeVO> selectNoticeList(SqlSession session);
}
