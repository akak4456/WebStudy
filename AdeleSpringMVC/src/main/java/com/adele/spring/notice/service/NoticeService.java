package com.adele.spring.notice.service;

import java.util.List;

import com.adele.spring.notice.domain.NoticeVO;

public interface NoticeService {
	/**
	 * 공지사항 등록 Service
	 * @param notice
	 * @return Integer
	 */
	int insertNotice(NoticeVO notice);
	
	/**
	 * 공지사항 목록조회 Service
	 * @return List<NoticeVO>
	 */
	List<NoticeVO> selectNoticeList();
}
