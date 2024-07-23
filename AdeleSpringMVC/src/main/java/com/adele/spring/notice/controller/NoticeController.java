package com.adele.spring.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	@RequestMapping(value="/notice/register.kh", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		return "notice/register";
	}
}
