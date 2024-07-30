package com.adele.spring.notice.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
	public List<NoticeVO> selectNoticeList(SqlSession session, int currentPage) {
		int limit = 10;
		RowBounds rowBounds = new RowBounds((currentPage - 1) * limit, limit);
		List<NoticeVO> nList = session.selectList("NoticeMapper.selectList", null, rowBounds);
		return nList;
	}

	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}

	@Override
	public NoticeVO selectOneByNo(SqlSession session, int noticeNo) {
		NoticeVO result = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession session, Integer noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public List<NoticeVO> selectSearchList(SqlSession session, Map<String, String> paramMap) {
		List<NoticeVO> searchList = session.selectList("NoticeMapper.selectSearchList", paramMap);
		return searchList;
	}

}
