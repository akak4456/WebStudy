package com.adele.spring.notice.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adele.spring.notice.domain.NoticeVO;
import com.adele.spring.notice.service.NoticeService;
import com.adele.spring.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private SqlSession session;
	@Autowired
	private NoticeStore nStore;

	@Override
	public int insertNotice(NoticeVO notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectNoticeList() {
		List<NoticeVO> nList = nStore.selectNoticeList(session);
		return nList;
	}

}
