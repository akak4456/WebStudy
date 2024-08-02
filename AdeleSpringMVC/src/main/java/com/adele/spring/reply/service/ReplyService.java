package com.adele.spring.reply.service;

import java.util.List;

import com.adele.spring.reply.domain.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO reply);

	List<ReplyVO> selectReplyList(int noticeNo);

}
