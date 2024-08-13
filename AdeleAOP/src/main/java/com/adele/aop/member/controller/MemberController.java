package com.adele.aop.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@RequestMapping(value = "/member/register", method = RequestMethod.GET)
	public String showForm(Model model) {
		return "member/register";
	}
}
