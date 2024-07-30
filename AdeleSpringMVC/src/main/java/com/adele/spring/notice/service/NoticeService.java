package com.adele.spring.notice.service;

import java.util.List;
import java.util.Map;

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
	List<NoticeVO> selectNoticeList(int currentPage);
	
	int getTotalCount();

	NoticeVO selectOneByNo(int noticeNo);

	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return
	 */
	int deleteNotice(Integer noticeNo);

	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return
	 */
	int updateNotice(NoticeVO notice);

	/**
	 * 공지사항 게시물 검색 Service
	 * @param paramMap
	 * @return
	 */
	List<NoticeVO> searchNoticesByKeyword(Map<String, String> paramMap);
}
