package com.adele.spring.reply.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adele.spring.reply.domain.ReplyVO;
import com.adele.spring.reply.service.ReplyService;
import com.adele.spring.reply.store.ReplyStore;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private SqlSession session;
	@Autowired
	private ReplyStore rStore;
	@Override
	public int insertReply(ReplyVO reply) {
		int result = rStore.insertReply(session, reply);
		return result;
	}
	@Override
	public List<ReplyVO> selectReplyList(int refNoticeNo) {
		List<ReplyVO> rList
		= rStore.selectReplyList(session, refNoticeNo);
		return rList;
	}

}
