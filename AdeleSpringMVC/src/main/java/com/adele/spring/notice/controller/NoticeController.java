package com.adele.spring.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adele.spring.notice.domain.NoticeVO;
import com.adele.spring.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	@RequestMapping(value="/notice/list.kh", method=RequestMethod.GET)
	public String showNoticeList(Model model) {
		try {
			List<NoticeVO> nList = nService.selectNoticeList();
			if(nList.size() > 0) {
				model.addAttribute("nList", nList);
				return "notice/list";
			} else {
				model.addAttribute("msg", "정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value = "/notice/register.kh", method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "notice/register";
	}

	@RequestMapping(value = "/notice/register.kh", method = RequestMethod.POST)
	public String noticeRegister(Model model, HttpSession session,@RequestParam("noticeSubject") String noticeSubject,
			@RequestParam("noticeContent") String noticeContent) {
		try {
			String noticeWriter = (String)session.getAttribute("memberId");
			NoticeVO notice = new NoticeVO(noticeSubject, noticeContent, noticeWriter);
			int result = nService.insertNotice(notice);
			if(result > 0) {
				return "redirect:/notice/list.kh";
			} else {
				model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
