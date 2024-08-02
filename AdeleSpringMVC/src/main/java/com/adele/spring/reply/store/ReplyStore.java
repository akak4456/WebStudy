package com.adele.spring.reply.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.adele.spring.reply.domain.ReplyVO;

public interface ReplyStore {

	int insertReply(SqlSession session, ReplyVO reply);

	List<ReplyVO> selectReplyList(SqlSession session, int refNoticeNo);

}
