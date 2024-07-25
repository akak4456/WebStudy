package com.adele.spring.notice.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.adele.spring.notice.domain.NoticeVO;
import com.adele.spring.notice.store.NoticeStore;

@Repository
public class NoticeStoreImpl implements NoticeStore {

	@Override
	public int insertNotice(SqlSession session, NoticeVO notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session) {
		List<NoticeVO> nList = session.selectList("NoticeMapper.selectList");
		return nList;
	}

}
