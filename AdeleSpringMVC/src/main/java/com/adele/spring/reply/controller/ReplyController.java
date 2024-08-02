package com.adele.spring.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adele.spring.reply.domain.ReplyVO;
import com.adele.spring.reply.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value="/insert.kh", method=RequestMethod.POST)
	public String insertReply(ReplyVO reply, Model model) {
		int result = rService.insertReply(reply);
		return "redirect:/notice/detail.kh?noticeNo=" + reply.getRefNoticeNo();
	}
}
